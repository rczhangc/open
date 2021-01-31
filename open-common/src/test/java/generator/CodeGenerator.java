package generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.sun.javafx.PlatformUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author barnak
 */
public class CodeGenerator {

    /**
     * modular 名字
     */
    public static final String MODULAR_NAME = "";

    /**
     * 基本路径
     */
    public static final String SRC_MAIN_JAVA = "open-main/src/main/java/";

    /**
     * 作者
     */
    public static final String AUTHOR = "barnak";

    public static final String JDBC_MYSQL_URL = "jdbc:mysql://localhost:3306/local_bsx_db?" +
            "serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8";

    public static final String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    public static final String JDBC_USERNAME = "root";

    public static final String JDBC_PASSWORD = "123456";

    public static void main(String[] args) {
        String moduleName = scanner("模块名");
        String tableName = scanner("表名");
        String tablePrefix = scanner("表前缀(无前缀输入#)").replaceAll("#", "");
        autoGenerator(moduleName, tableName, tablePrefix);
    }

    public static void autoGenerator(String moduleName, String tableName, String tablePrefix) {
        new AutoGenerator()
                .setDataSource(getDataSourceConfig())
                .setStrategy(getStrategyConfig(tableName, tablePrefix))
                .setPackageInfo(getPackageConfig(moduleName))
                .setTemplate(getTemplateConfig())
                .setGlobalConfig(getGlobalConfig())
//                .setCfg(getInjectionConfig(moduleName))
                .execute();
    }


    // ----------------------------------------------------配置信息------------------------------------------------------

    /**
     * 数据源配置
     *
     * @return {@link DataSourceConfig}
     */
    private static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                .setUrl(JDBC_MYSQL_URL)
                .setDriverName(JDBC_DRIVER_NAME)
                .setUsername(JDBC_USERNAME)
                .setPassword(JDBC_PASSWORD);
    }

    /**
     * 数据库表配置
     *
     * @param tableName 表名称
     * @param tablePrefix 表前缀
     * @return {@link StrategyConfig}
     */
    private static StrategyConfig getStrategyConfig(String tableName, String tablePrefix) {
        return new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix(tablePrefix + "_")
                .setInclude(tableName)
                .setChainModel(true)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .setEntityTableFieldAnnotationEnable(true);
    }

    /**
     * 包名配置
     *
     * @param moduleName 模块名称
     * @return {@link PackageConfig}
     */
    private static PackageConfig getPackageConfig(String moduleName) {
        return new PackageConfig()
                .setModuleName(moduleName)
                .setParent("org.tools.main")
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller")
                .setEntity("entity");
    }

    /**
     * 模板配置
     *
     * @return {@link TemplateConfig}
     */
    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                .setController("/templates-generator/controller.java.vm")
                .setService("/templates-generator/service.java.vm")
                .setServiceImpl("/templates-generator/serviceImpl.java.vm")
                .setEntity("/templates-generator/entity.java.vm")
                .setMapper("/templates-generator/mapper.java.vm")
                .setXml("/templates-generator/mapper.xml.vm");
    }

    /**
     * 全局策略配置
     *
     * @return {@link GlobalConfig}
     */
    private static GlobalConfig getGlobalConfig() {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/" + MODULAR_NAME + SRC_MAIN_JAVA;
        if (PlatformUtil.isWindows()) {
            filePath = filePath.replaceAll("/+|\\\\+", "\\\\");
        } else {
            filePath = filePath.replaceAll("/+|\\\\+", "/");
        }
        return new GlobalConfig()
                .setOutputDir(filePath)
                .setDateType(DateType.ONLY_DATE)
                .setAuthor(AUTHOR)
                .setSwagger2(true)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setIdType(IdType.UUID)
                .setOpen(false);
    }

    /**
     * 注入配置
     *
     * @param moduleName 模块名称
     * @return {@link InjectionConfig}
     */
    private static InjectionConfig getInjectionConfig(final String moduleName) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("dateTime", getDateTime());
        final String projectPath = System.getProperty("user.dir");
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        // 自定义配置会被优先输出
        fileOutConfigList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名，如果entity设置了前后缀，此次注意xml的名称也会跟着发生变化
                return projectPath + SRC_MAIN_JAVA + moduleName + "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        return new InjectionConfig() {
            @Override
            public void initMap() {
                setMap(maps);
                setFileOutConfigList(fileOutConfigList);
            }
        };
    }

    private static String getDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDate.format(formatter);
    }



    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input " + tip + " : ");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("please input the correct " + tip + ". ");
    }
}
