package generator.module;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.sun.javafx.PlatformUtil;
import generator.DataBaseConstants;
import generator.GeneratorConstants;
import generator.ModuleInfo;

/**
 * 基础生成类
 *
 * @author barnak
 */
public abstract class BaseGenerator {

    /**
     * 获取生成器
     *
     * @return {@link AutoGenerator}
     */
    public AutoGenerator getGenerator(ModuleInfo moduleInfo) {
        return new AutoGenerator()
                .setDataSource(getDataSourceConfig())
                .setStrategy(getStrategyConfig(moduleInfo.getTablePrefix(),moduleInfo.getTableNameList().toArray(new String[0])))
                .setPackageInfo(getPackageConfig(moduleInfo.getModuleName()))
                .setTemplate(getTemplateConfig())
                .setGlobalConfig(getGlobalConfig(getModulePackage()));
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
    private StrategyConfig getStrategyConfig(String tablePrefix, String ... tableName) {
        StrategyConfig strategyConfig = new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix(tablePrefix + "_")
                .setInclude(tableName)
                .setChainModel(true)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .setEntityTableFieldAnnotationEnable(true);
        setStrategyConfig(strategyConfig);
        return strategyConfig;
    }



    /**
     * 包名配置
     *
     * @param moduleName 模块名称
     * @return {@link PackageConfig}
     */
    private PackageConfig getPackageConfig(String moduleName) {
        PackageConfig packageConfig =  new PackageConfig()
                .setModuleName("")
                .setParent("org.tools")
                .setService("service."+ moduleName)
                .setServiceImpl("service."+ moduleName +".impl")
                .setController("controller."+ moduleName)
                .setMapper("dao."+ moduleName)
                .setXml("dao."+ moduleName +".xml")
                .setEntity("dao."+ moduleName +".entity");
        setPackageConfig(packageConfig, moduleName);
        return packageConfig;
    }

    /**
     * 模板配置
     *
     * @return {@link TemplateConfig}
     */
    private TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig()
                .setController("")
                .setService("")
                .setServiceImpl("")
                .setEntity("")
                .setMapper("")
                .setXml("");
        setTemplateConfig(templateConfig);
        return templateConfig;
    }



    /**
     * 全局策略配置
     *
     * @param modulePackage 模块包名
     * @return {@link GlobalConfig}
     */
    private GlobalConfig getGlobalConfig(String modulePackage) {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/" + modulePackage +"/"+ GeneratorConstants.SRC_MAIN_JAVA +"/";
        if (PlatformUtil.isWindows()) {
            filePath = filePath.replaceAll("/+|\\\\+", "\\\\");
        } else {
            filePath = filePath.replaceAll("/+|\\\\+", "/");
        }
        GlobalConfig globalConfig = new GlobalConfig()
                .setOutputDir(filePath)
                .setDateType(DateType.ONLY_DATE)
                .setAuthor(GeneratorConstants.AUTHOR)
                .setSwagger2(true)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setIdType(IdType.ASSIGN_UUID)
                .setOpen(false);
        setGlobalConfig(globalConfig);
        return globalConfig;
    }

    /**
     * 获取模块包名
     *
     * @return 模块包名
     */
    protected abstract String getModulePackage();

    /**
     * 设置全局配置
     *
     * @param globalConfig {@link GlobalConfig}
     */
    protected abstract void setGlobalConfig(GlobalConfig globalConfig);

    /**
     * 设置模板对象
     *
     * @param templateConfig {@link TemplateConfig}
     */
    protected abstract void setTemplateConfig(TemplateConfig templateConfig);

    /**
     * 设置包对象
     *
     * @param packageConfig {@link PackageConfig}
     * @param moduleName 模块名称
     */
    protected abstract void setPackageConfig(PackageConfig packageConfig, String moduleName);

    /**
     * 设置数据库表对象
     *
     * @param strategyConfig {@link StrategyConfig}
     */
    protected abstract void setStrategyConfig(StrategyConfig strategyConfig);
}
