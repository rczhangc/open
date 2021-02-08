package org.open.boot.dao.system.business;

import org.open.boot.dao.system.entity.SysGlobalConfigDO;

import java.io.Serializable;

/**
 * 系统全局配置实体类BO
 *
 * @author barnak
 */
public class SysGlobalConfigBO extends SysGlobalConfigDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "SysGlobalConfigBO{" +
                "configCode=" + super.getConfigCode() +
                ", groupFlag=" + super.getGroupFlag() +
                ", jsonValue=" + super.getJsonValue() +
                ", insertTime=" + super.getInsertTime() +
                ", updateTime=" + super.getUpdateTime() +
                ", isDeleted=" + super.getIsDeleted() +
                "}";
    }
}