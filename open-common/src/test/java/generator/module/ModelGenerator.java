package generator.module;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;

/**
 * @author barnak
 */
public class ModelGenerator extends BaseGenerator {

    @Override
    protected String getModulePackage() {
        return MavenModuleEnum.OPEN_MODEL.getModulePackage();
    }

    @Override
    protected void setGlobalConfig(GlobalConfig globalConfig) {
        globalConfig.setEntityName("%sDO")
                .setServiceName("%sBO");
    }

    @Override
    protected void setTemplateConfig(TemplateConfig templateConfig) {
        templateConfig.setController("")
                .setService("/templates-generator/dao/business/businessObject.java.vm")
                .setServiceImpl("")
                .setEntity("/templates-generator/dao/entity/entity.java.vm")
                .setMapper("")
                .setXml("");
    }

    @Override
    protected void setPackageConfig(PackageConfig packageConfig, String moduleName) {
        packageConfig.setModuleName("")
                .setService("dao."+ moduleName +".business")
                .setEntity("dao."+ moduleName +".entity");
    }

    @Override
    protected void setStrategyConfig(StrategyConfig strategyConfig) {

    }
}
