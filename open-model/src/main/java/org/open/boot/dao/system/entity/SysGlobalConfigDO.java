package org.open.boot.dao.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import org.open.boot.dao.user.entity.UserDO;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统全局配置实体类
 *
 * @author barnak
 */
@TableName(value = "sys_global_config", autoResultMap = true)
public class SysGlobalConfigDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 配置CODE值
     */
    @TableId(value = "config_code", type = IdType.ASSIGN_UUID)
    private String configCode;

    /**
     * 分组标识
     */
    @TableField("group_flag")
    private String groupFlag;

    /**
     * 配置值
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private UserDO jsonValue;

    /**
     * 新增时间
     */
    @TableField("insert_time")
    private Date insertTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 已删除：0否，1是
     */
    @TableField("is_deleted")
    private Boolean isDeleted;


    public String getConfigCode() {
        return configCode;
    }

    public SysGlobalConfigDO setConfigCode(String configCode) {
        this.configCode = configCode;
        return this;
    }

    public String getGroupFlag() {
        return groupFlag;
    }

    public SysGlobalConfigDO setGroupFlag(String groupFlag) {
        this.groupFlag = groupFlag;
        return this;
    }

    public UserDO getJsonValue() {
        return jsonValue;
    }

    public SysGlobalConfigDO setJsonValue(UserDO jsonValue) {
        this.jsonValue = jsonValue;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public SysGlobalConfigDO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SysGlobalConfigDO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public SysGlobalConfigDO setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "SysGlobalConfigDO{" +
            "configCode=" + configCode +
            ", groupFlag=" + groupFlag +
            ", jsonValue=" + jsonValue +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}