package org.open.boot.dao.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;


/**
 * 用户信息表实体类
 *
 * @author barnak
 */
@TableName("users")
public class UsersDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登录名称
     */
    @TableField("login_named")
    private String loginNamed;

    /**
     * 登录密码
     */
    @TableField("login_password")
    private String loginPassword;

    /**
     * 昵称
     */
    @TableField("nick_named")
    private String nickNamed;

    /**
     * 头像链接
     */
    @TableField("profile_url")
    private String profileUrl;

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
     * 已删除：0否
     */
    @TableField("is_deleted")
    private Long isDeleted;


    public Long getId() {
        return id;
    }

    public UsersDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLoginNamed() {
        return loginNamed;
    }

    public UsersDO setLoginNamed(String loginNamed) {
        this.loginNamed = loginNamed;
        return this;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public UsersDO setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
        return this;
    }

    public String getNickNamed() {
        return nickNamed;
    }

    public UsersDO setNickNamed(String nickNamed) {
        this.nickNamed = nickNamed;
        return this;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public UsersDO setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
        return this;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public UsersDO setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UsersDO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public UsersDO setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    @Override
    public String toString() {
        return "UsersDO{" +
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