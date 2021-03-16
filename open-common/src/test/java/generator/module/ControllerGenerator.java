package generator.module;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;

/**
 * @author barnak
 */
public class ControllerGenerator extends BaseGenerator {

    @Override
    protected MavenModuleEnum getModule() {
        return MavenModuleEnum.OPEN_MAIN;
    }

    @Override
    protected void setGlobalConfig(GlobalConfig globalConfig) {
        globalConfig.setControllerName("%sController")
                .setEntityName("%sVO");
    }

    @Override
    protected void setTemplateConfig(TemplateConfig templateConfig) {
        templateConfig.setController("/templates-generator/controller/controller.java.vm")
                .setService("")
                .setServiceImpl("")
                .setEntity("/templates-generator/controller/view/viewObject.java.vm")
                .setMapper("")
                .setXml("");
    }

    @Override
    protected void setPackageConfig(PackageConfig packageConfig, String moduleName) {
        packageConfig.setModuleName("")
                .setController("controller."+ moduleName)
                .setEntity("controller."+ moduleName +".view")
                .setXml(moduleName);
    }

    @Override
    protected void setStrategyConfig(StrategyConfig strategyConfig) {
    }
}
