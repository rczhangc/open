package generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.sun.javafx.PlatformUtil;

import java.util.Collections;
import java.util.List;

/**
 * @author barnak
 */
public class CodeGenerator {


    /**
     * 基本路径
     */
    public static final String SRC_MAIN_JAVA = "src/main/java";

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
//        String moduleName = scanner("模块名");
//        String tableName = scanner("表名");
//        String tablePrefix = scanner("表前缀(无前缀输入#)").replaceAll("#", "");
//        autoGenerator(moduleName, tableName, tablePrefix);
        autoGenerator("user", "user", "#");

        ModuleInfo moduleInfo = new ModuleInfo();
        moduleInfo.setModuleName("user");
        moduleInfo.setTableNameList(Collections.singletonList("user"));


    }

    public static void autoGenerator(String module, String moduleName, String tablePrefix, String ... tableName) {
        new AutoGenerator()
                .setDataSource(getDataSourceConfig())
                .setStrategy(getStrategyConfig(tablePrefix, tableName))
                .setPackageInfo(getPackageConfig(moduleName))
                .setTemplate(getTemplateConfig())
                .setGlobalConfig(getGlobalConfig(module))
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
    private static StrategyConfig getStrategyConfig(String tablePrefix, String ... tableName) {
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
                //.setController("/templates-generator/controller.java.vm")
                .setController("")
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
    private static GlobalConfig getGlobalConfig(String module) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/" + module +"/"+ SRC_MAIN_JAVA +"/";
        if (PlatformUtil.isWindows()) {
            filePath = filePath.replaceAll("/+|\\\\+", "\\\\");
        } else {
            filePath = filePath.replaceAll("/+|\\\\+", "/");
        }
        return new GlobalConfig()
                .setOutputDir(filePath)
                .setDateType(DateType.TIME_PACK)
                .setAuthor(AUTHOR)
                .setSwagger2(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setIdType(IdType.ASSIGN_UUID)
                .setOpen(false);
    }

    /**
     * 模块信息
     *
     * @author barnak
     */
    public static class ModuleInfo {

        /**
         * 模块名称
         */
        private String moduleName;

        /**
         * 表前缀
         */
        private String tablePrefix;

        /**
         * 模块下表名称
         */
        private List<String> tableNameList;

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public String getTablePrefix() {
            return tablePrefix;
        }

        public void setTablePrefix(String tablePrefix) {
            this.tablePrefix = tablePrefix;
        }

        public List<String> getTableNameList() {
            return tableNameList;
        }

        public void setTableNameList(List<String> tableNameList) {
            this.tableNameList = tableNameList;
        }
    }
}
