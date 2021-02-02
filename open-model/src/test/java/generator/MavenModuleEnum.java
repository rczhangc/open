package generator;

/**
 * @author barnak
 */
public enum MavenModuleEnum {

    OPEN_MODEL("open-model","数据库模型"),
    OPEN_DAO("open-dao","数据库服务"),
    OPEN_COMMON("open-common","通用模块"),
    OPEN_MAIN("open-main","业务处理")
    ;

    MavenModuleEnum(String modulePackage, String moduleDesc) {
        this.modulePackage = modulePackage;
        this.moduleDesc = moduleDesc;
    }

    /**
     * 模块包
     */
    private final String modulePackage;

    /**
     * 模块描述
     */
    private final String moduleDesc;

    public String getModulePackage() {
        return modulePackage;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }
}
