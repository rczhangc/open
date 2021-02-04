package generator.module;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;

/**
 * @author barnak
 */
public class CommonGenerator extends BaseGenerator {

    @Override
    protected String getModulePackage() {
        return MavenModuleEnum.OPEN_COMMON.getModulePackage();
    }

    @Override
    protected void setGlobalConfig(GlobalConfig globalConfig) {
        globalConfig.setServiceName("%sService")
                .setServiceImplName("%sServiceImpl");
    }

    @Override
    protected void setTemplateConfig(TemplateConfig templateConfig) {
        templateConfig.setController("")
                .setService("")
                .setServiceImpl("")
                .setEntity("")
                .setMapper("")
                .setXml("");
    }

    @Override
    protected void setPackageConfig(PackageConfig packageConfig, String moduleName) {
        packageConfig.setModuleName("")
                .setMapper("dao."+ moduleName)
                .setParent("org.tools")
                .setService("manager."+ moduleName)
                .setServiceImpl("manager."+ moduleName +".impl")
                .setEntity("manager."+ moduleName +".business");
    }

    @Override
    protected void setStrategyConfig(StrategyConfig strategyConfig) {
    }
}
