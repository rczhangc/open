package org.open.boot.dao.page.business;

import org.open.boot.dao.page.entity.PageDO;

import java.io.Serializable;

/**
 * 页面信息表（页面定义）实体类BO
 *
 * @author barnak
 */
public class PageBO extends PageDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "PageBO{" +
                "id=" + super.getId() +
                ", pageTitle=" + super.getPageTitle() +
                ", pageCode=" + super.getPageCode() +
                ", isShow=" + super.getIsShow() +
                ", authStatus=" + super.getAuthStatus() +
                ", isDefault=" + super.getIsDefault() +
                ", weightValue=" + super.getWeightValue() +
                ", extend=" + super.getExtend() +
                ", inputTime=" + super.getInputTime() +
                ", updateTime=" + super.getUpdateTime() +
                ", creatorId=" + super.getCreatorId() +
                ", reviserId=" + super.getReviserId() +
                ", isDel=" + super.getIsDel() +
                "}";
    }
}