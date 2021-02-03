package generator.module;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;

/**
 * @author barnak
 */
public class ServiceGenerator extends BaseGenerator {
    @Override
    protected String getModulePackage() {
        return MavenModuleEnum.OPEN_SERVICE.getModulePackage();
    }

    @Override
    protected void setGlobalConfig(GlobalConfig globalConfig) {
        globalConfig.setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setMapperName("%sManager");
    }

    @Override
    protected void setTemplateConfig(TemplateConfig templateConfig) {
        templateConfig.setController("")
                .setService("/templates-generator/service/service.java.vm")
                .setServiceImpl("/templates-generator/service/impl/serviceImpl.java.vm")
                .setEntity("")
                .setMapper("")
                .setXml("");
    }

    @Override
    protected void setPackageConfig(PackageConfig packageConfig, String moduleName) {
        packageConfig.setModuleName("")
                .setMapper("dao."+ moduleName)
                .setService("service."+ moduleName)
                .setServiceImpl("service."+ moduleName +".impl");
    }

    @Override
    protected void setStrategyConfig(StrategyConfig strategyConfig) {

    }
}
