package generator;

import java.util.List;

/**
 * @author barnak
 */
public class ModuleInfo {
    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 表前缀
     */
    private String tablePrefix;

    /**
     * 模块下表名称
     */
    private List<String> tableNameList;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public List<String> getTableNameList() {
        return tableNameList;
    }

    public void setTableNameList(List<String> tableNameList) {
        this.tableNameList = tableNameList;
    }
}
