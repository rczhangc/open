package generator.module;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;

/**
 * @author barnak
 */
public class DaoGenerator extends BaseGenerator {
    @Override
    protected MavenModuleEnum getModule() {
        return MavenModuleEnum.OPEN_DAO;
    }

    @Override
    protected void setGlobalConfig(GlobalConfig globalConfig) {
        globalConfig.setEntityName("%sDO")
            .setServiceName("%sManager")
            .setServiceImplName("%sManagerImpl");
    }

    @Override
    protected void setTemplateConfig(TemplateConfig templateConfig) {
        templateConfig.setController("")
                .setService("/templates-generator/dao/manager.java.vm")
                .setServiceImpl("/templates-generator/dao/impl/managerImpl.java.vm")
                .setEntity("")
                .setMapper("/templates-generator/dao/impl/mapper.java.vm")
                .setXml("");
    }

    @Override
    protected void setPackageConfig(PackageConfig packageConfig, String moduleName) {
        packageConfig.setModuleName("")
                .setService("dao."+ moduleName)
                .setServiceImpl("dao."+ moduleName +".impl")
                .setMapper("dao."+ moduleName +".impl")
                .setXml("dao."+ moduleName +".xml")
                .setEntity("dao."+ moduleName +".entity");
    }

    @Override
    protected void setStrategyConfig(StrategyConfig strategyConfig) {

    }
}
