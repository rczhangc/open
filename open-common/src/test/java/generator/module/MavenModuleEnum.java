package generator.module;

/**
 * @author barnak
 */
public enum MavenModuleEnum {

    OPEN_MODEL("open-model","数据库模型", ModelGenerator.class),
    OPEN_DAO("open-dao","数据库服务", DaoGenerator.class),
    OPEN_COMMON("open-common","通用模块", CommonGenerator.class),
    OPEN_SERVICE("open-service","业务服务模块", ServiceGenerator.class),
    OPEN_MAIN("open-controller","业务处理", ControllerGenerator.class),
    ;

    MavenModuleEnum(String modulePackage, String moduleDesc, Class<? extends BaseGenerator> clazz) {
        this.modulePackage = modulePackage;
        this.moduleDesc = moduleDesc;
        this.clazz = clazz;
    }

    /**
     * 模块包
     */
    private final String modulePackage;

    /**
     * 模块描述
     */
    private final String moduleDesc;

    private final Class<? extends BaseGenerator> clazz;

    public String getModulePackage() {
        return modulePackage;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public Class<? extends BaseGenerator> getClazz() {
        return clazz;
    }
}
