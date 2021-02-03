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
    protected String getModulePackage() {
        return MavenModuleEnum.OPEN_MAIN.getModulePackage();
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
                .setParent("org.tools")
                .setController("controller."+ moduleName)
                .setEntity("controller."+ moduleName +".view");
    }

    @Override
    protected void setStrategyConfig(StrategyConfig strategyConfig) {
    }
}
