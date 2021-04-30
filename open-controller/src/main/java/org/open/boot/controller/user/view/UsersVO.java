package org.open.boot.controller.user.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 用户信息表实体类
 *
 * @author barnak
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="UsersVO对象", description="用户信息表")
public class UsersVO implements Serializable {

private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "登录名称")
    private String loginNamed;

    @ApiModelProperty(value = "登录密码")
    private String loginPassword;

    @ApiModelProperty(value = "昵称")
    private String nickNamed;

    @ApiModelProperty(value = "头像链接")
    private String profileUrl;

    @ApiModelProperty(value = "新增时间")
    private Date insertTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "已删除：0否")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public UsersVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLoginNamed() {
        return loginNamed;
    }

    public UsersVO setLoginNamed(String loginNamed) {
        this.loginNamed = loginNamed;
        return this;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public UsersVO setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
        return this;
    }

    public String getNickNamed() {
        return nickNamed;
    }

    public UsersVO setNickNamed(String nickNamed) {
        this.nickNamed = nickNamed;
        return this;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public UsersVO setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public UsersVO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UsersVO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public UsersVO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "UsersVO{" +
            "id=" + id +
            ", loginNamed=" + loginNamed +
            ", loginPassword=" + loginPassword +
            ", nickNamed=" + nickNamed +
            ", profileUrl=" + profileUrl +
            ", insertTime=" + insertTime +
            ", updateTime=" + updateTime +
            ", isDeleted=" + isDeleted +
            "}";
    }
}