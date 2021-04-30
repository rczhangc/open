package generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import generator.module.BaseGenerator;
import generator.module.MavenModuleEnum;

import java.util.*;

/**
 * @author barnak
 */
public class CodeGenerator {

    public static Map<String,BaseGenerator> generatorMap = new HashMap<>(MavenModuleEnum.values().length);

    /**
     * 生成函数
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // 初始化
        initGeneratorMap();
        List<ModuleInfo> moduleInfoList = new ArrayList<>();
        ModuleInfo module = new ModuleInfo();
        module.setModuleName("permission");
        module.setTableNameList(Arrays.asList("user_roles_relation","roles","menus","roles_menus_relation"));
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
        BaseGenerator baseGenerator = generatorMap.get(mavenModule.getModulePackage());
        return baseGenerator.getGenerator(moduleInfo);
    }

    /**
     * 初始化生成器
     *
     * @throws IllegalAccessException 异常{@link IllegalAccessException}
     * @throws InstantiationException 异常{@link InstantiationException}
     */
    private static void initGeneratorMap() throws IllegalAccessException, InstantiationException {
        for (MavenModuleEnum mavenModule : MavenModuleEnum.values()) {
            BaseGenerator baseGenerator = mavenModule.getClazz().newInstance();
            generatorMap.put(mavenModule.getModulePackage(), baseGenerator);
        }
    }
}
