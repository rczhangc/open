package generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.sun.javafx.PlatformUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author barnak
 */
public class CodeGenerator {

    public static void main(String[] args) {

        List<ModuleInfo> moduleInfoList = new ArrayList<>();
        ModuleInfo module = new ModuleInfo();
        module.setModuleName("user");
        module.setTableNameList(Collections.singletonList("user"));
        module.setTablePrefix("");
        moduleInfoList.add(module);

        autoGenerator(moduleInfoList);

    }

    /**
     * 自动生成
     *
     * @param moduleInfoList {@link List<ModuleInfo>}
     */
    public static void autoGenerator(List<ModuleInfo> moduleInfoList) {
        List<AutoGenerator> generatorsList = new ArrayList<>(MavenModuleEnum.values().length);
        for (MavenModuleEnum mavenModule : MavenModuleEnum.values()) {
            for (ModuleInfo moduleInfo : moduleInfoList) {
                AutoGenerator autoGenerator = getGenerator(mavenModule, moduleInfo);
                generatorsList.add(autoGenerator);
            }
        }
        // 批量执行生成
        for (AutoGenerator autoGenerator : generatorsList) {
            autoGenerator.execute();
        }
    }

    /**
     * 获取生成器
     *
     * @param mavenModule {@link MavenModuleEnum}
     * @param moduleInfo {@link ModuleInfo}
     * @return {@link AutoGenerator}
     */
    public static AutoGenerator getGenerator(MavenModuleEnum mavenModule, ModuleInfo moduleInfo) {
        return new AutoGenerator()
                .setDataSource(getDataSourceConfig())
                .setStrategy(getStrategyConfig(moduleInfo.getTablePrefix(),moduleInfo.getTableNameList().toArray(new String[0])))
                .setPackageInfo(getPackageConfig(moduleInfo.getModuleName(), mavenModule))
                .setTemplate(getTemplateConfig(mavenModule))
                .setGlobalConfig(getGlobalConfig(mavenModule.getModulePackage()));
    }

    // ----------------------------------------------------配置信息------------------------------------------------------

    /**
     * 数据源配置
     *
     * @return {@link DataSourceConfig}
     */
    private static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                .setUrl(DataBaseConstants.JDBC_MYSQL_URL)
                .setDriverName(DataBaseConstants.JDBC_DRIVER_NAME)
                .setUsername(DataBaseConstants.JDBC_USERNAME)
                .setPassword(DataBaseConstants.JDBC_PASSWORD);
    }

    /**
     * 数据库表配置
     *
     * @param tablePrefix 表前缀
     * @param tableName 表名称
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
    private static PackageConfig getPackageConfig(String moduleName, MavenModuleEnum mavenModule) {
        if (MavenModuleEnum.OPEN_MODEL.equals(mavenModule)) {
            return new PackageConfig()
                    .setModuleName("")
                    .setParent("org.tools")
                    .setEntity("dao."+ moduleName +".entity");
        }
        if (MavenModuleEnum.OPEN_DAO.equals(mavenModule)) {
            return new PackageConfig()
                    .setModuleName("")
                    .setParent("org.tools")
                    .setMapper("dao."+ moduleName)
                    .setXml("dao."+ moduleName +".xml");
        }
        if (MavenModuleEnum.OPEN_COMMON.equals(mavenModule)) {
            return new PackageConfig()
                    .setModuleName("")
                    .setParent("org.tools")
                    .setService("manager."+ moduleName)
                    .setServiceImpl("manager."+ moduleName +".impl")
                    .setEntity("manager."+ moduleName +".business");
        }
        if (MavenModuleEnum.OPEN_MAIN.equals(mavenModule)) {
            return new PackageConfig()
                    .setModuleName("")
                    .setParent("org.tools")
                    .setController("controller."+ moduleName)
                    .setEntity("controller."+ moduleName +".view");
        }
        return new PackageConfig()
                .setModuleName("")
                .setParent("org.tools")
                .setService("service."+ moduleName)
                .setServiceImpl("service."+ moduleName +".impl")
                .setController("controller."+ moduleName)
                .setEntity("entity."+ moduleName);
    }

    /**
     * 模板配置
     *
     * @param mavenModule {@link MavenModuleEnum}
     * @return {@link TemplateConfig}
     */
    private static TemplateConfig getTemplateConfig(MavenModuleEnum mavenModule) {
        TemplateConfig templateConfig = new TemplateConfig();
        if (MavenModuleEnum.OPEN_MODEL.equals(mavenModule)) {
            return templateConfig.setController("")
                    .setService("")
                    .setServiceImpl("")
                    .setEntity("/templates-generator/dao/entity/entity.java.vm")
                    .setMapper("")
                    .setXml("");
        }
        if (MavenModuleEnum.OPEN_DAO.equals(mavenModule)) {
            return templateConfig.setController("")
                    .setService("")
                    .setServiceImpl("")
                    .setEntity("")
                    .setMapper("/templates-generator/dao/mapper.java.vm")
                    .setXml("/templates-generator/dao/xml/mapper.xml.vm");
        }
        if (MavenModuleEnum.OPEN_COMMON.equals(mavenModule)) {
            return templateConfig.setController("")
                    .setService("/templates-generator/manager/manager.java.vm")
                    .setServiceImpl("/templates-generator/manager/impl/managerImpl.java.vm")
                    .setEntity("")
                    .setMapper("")
                    .setXml("");
        }
        if (MavenModuleEnum.OPEN_MAIN.equals(mavenModule)) {
            return templateConfig.setController("/templates-generator/controller/controller.java.vm")
                    .setService("")
                    .setServiceImpl("")
                    .setEntity("")
                    .setMapper("")
                    .setXml("");
        }
        return new TemplateConfig()
                .setController("")
                .setService("")
                .setServiceImpl("")
                .setEntity("")
                .setMapper("")
                .setXml("");
    }

    /**
     * 全局策略配置
     *
     * @param modulePackage 模块包名
     * @return {@link GlobalConfig}
     */
    private static GlobalConfig getGlobalConfig(String modulePackage) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/" + modulePackage +"/"+ GeneratorConstants.SRC_MAIN_JAVA +"/";
        if (PlatformUtil.isWindows()) {
            filePath = filePath.replaceAll("/+|\\\\+", "\\\\");
        } else {
            filePath = filePath.replaceAll("/+|\\\\+", "/");
        }
        return new GlobalConfig()
                .setOutputDir(filePath)
                .setDateType(DateType.ONLY_DATE)
                .setAuthor(GeneratorConstants.AUTHOR)
                .setSwagger2(true)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setIdType(IdType.ASSIGN_UUID)
                .setOpen(false);
    }

}
