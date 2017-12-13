package com.fl.auth.authshiro.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class TUser {
    /**
     * 主键
     */
    @Column(name = "n_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nId;

    /**
     * 用户名
     */
    @Column(name = "c_username")
    private String cUsername;

    /**
     * 密码
     */
    @Column(name = "c_password")
    private String cPassword;

    /**
     * 盐值
     */
    @Column(name = "c_salt")
    private String cSalt;

    /**
     * 邮箱
     */
    @Column(name = "c_email")
    private String cEmail;

    /**
     * 更新者
     */
    @Column(name = "n_create_user")
    private Integer nCreateUser;

    /**
     * 创建时间
     */
    @Column(name = "d_create_time")
    private Date dCreateTime;

    /**
     * 更新者
     */
    @Column(name = "n_update_user")
    private Integer nUpdateUser;

    /**
     * 更新时间
     */
    @Column(name = "d_update_time")
    private Date dUpdateTime;

    /**
     * 是否删除
     */
    @Column(name = "n_delete")
    private Boolean isDelete;

    /**
     * 获取主键
     *
     * @return n_id - 主键
     */
    public Integer getnId() {
        return nId;
    }

    /**
     * 设置主键
     *
     * @param nId 主键
     */
    public void setnId(Integer nId) {
        this.nId = nId;
    }

    /**
     * 获取用户名
     *
     * @return c_username - 用户名
     */
    public String getcUsername() {
        return cUsername;
    }

    /**
     * 设置用户名
     *
     * @param cUsername 用户名
     */
    public void setcUsername(String cUsername) {
        this.cUsername = cUsername;
    }

    /**
     * 获取密码
     *
     * @return c_password - 密码
     */
    public String getcPassword() {
        return cPassword;
    }

    /**
     * 设置密码
     *
     * @param cPassword 密码
     */
    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    /**
     * 获取盐值
     *
     * @return c_salt - 盐值
     */
    public String getcSalt() {
        return cSalt;
    }

    /**
     * 设置盐值
     *
     * @param cSalt 盐值
     */
    public void setcSalt(String cSalt) {
        this.cSalt = cSalt;
    }

    /**
     * 获取邮箱
     *
     * @return c_email - 邮箱
     */
    public String getcEmail() {
        return cEmail;
    }

    /**
     * 设置邮箱
     *
     * @param cEmail 邮箱
     */
    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    /**
     * 获取更新者
     *
     * @return n_create_user - 更新者
     */
    public Integer getnCreateUser() {
        return nCreateUser;
    }

    /**
     * 设置更新者
     *
     * @param nCreateUser 更新者
     */
    public void setnCreateUser(Integer nCreateUser) {
        this.nCreateUser = nCreateUser;
    }

    /**
     * 获取创建时间
     *
     * @return d_create_time - 创建时间
     */
    public Date getdCreateTime() {
        return dCreateTime;
    }

    /**
     * 设置创建时间
     *
     * @param dCreateTime 创建时间
     */
    public void setdCreateTime(Date dCreateTime) {
        this.dCreateTime = dCreateTime;
    }

    /**
     * 获取更新者
     *
     * @return n_update_user - 更新者
     */
    public Integer getnUpdateUser() {
        return nUpdateUser;
    }

    /**
     * 设置更新者
     *
     * @param nUpdateUser 更新者
     */
    public void setnUpdateUser(Integer nUpdateUser) {
        this.nUpdateUser = nUpdateUser;
    }

    /**
     * 获取更新时间
     *
     * @return d_update_time - 更新时间
     */
    public Date getdUpdateTime() {
        return dUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param dUpdateTime 更新时间
     */
    public void setdUpdateTime(Date dUpdateTime) {
        this.dUpdateTime = dUpdateTime;
    }

    /**
     * 获取是否删除
     *
     * @return n_delete - 是否删除
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除
     *
     * @param isDelete 是否删除
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}