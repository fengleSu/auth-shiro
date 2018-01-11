package com.fl.auth.authshiro.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_role")
public class TUserRole {
    /**
     * 主键id
     */
    @Id
    @Column(name = "n_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nId;

    /**
     * 用户id
     */
    @Column(name = "n_user_id")
    private Integer nUserId;

    /**
     * 角色id
     */
    @Column(name = "n_role_id")
    private Integer nRoleId;

    /**
     * 创建者
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
     * 修改时间
     */
    @Column(name = "d_update_time")
    private Date dUpdateTime;

    /**
     * 是否删除
     */
    @Column(name = "n_delete")
    private Boolean delete;

    /**
     * 获取主键id
     *
     * @return n_id - 主键id
     */
    public Integer getnId() {
        return nId;
    }

    /**
     * 设置主键id
     *
     * @param nId 主键id
     */
    public void setnId(Integer nId) {
        this.nId = nId;
    }

    /**
     * 获取用户id
     *
     * @return n_user_id - 用户id
     */
    public Integer getnUserId() {
        return nUserId;
    }

    /**
     * 设置用户id
     *
     * @param nUserId 用户id
     */
    public void setnUserId(Integer nUserId) {
        this.nUserId = nUserId;
    }

    /**
     * 获取角色id
     *
     * @return n_role_id - 角色id
     */
    public Integer getnRoleId() {
        return nRoleId;
    }

    /**
     * 设置角色id
     *
     * @param nRoleId 角色id
     */
    public void setnRoleId(Integer nRoleId) {
        this.nRoleId = nRoleId;
    }

    /**
     * 获取创建者
     *
     * @return n_create_user - 创建者
     */
    public Integer getnCreateUser() {
        return nCreateUser;
    }

    /**
     * 设置创建者
     *
     * @param nCreateUser 创建者
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
     * 获取修改时间
     *
     * @return d_update_time - 修改时间
     */
    public Date getdUpdateTime() {
        return dUpdateTime;
    }

    /**
     * 设置修改时间
     *
     * @param dUpdateTime 修改时间
     */
    public void setdUpdateTime(Date dUpdateTime) {
        this.dUpdateTime = dUpdateTime;
    }

    /**
     * 获取是否删除
     *
     * @return n_delete - 是否删除
     */
    public Boolean getDelete() {
        return delete;
    }

    /**
     * 设置是否删除
     *
     * @param delete 是否删除
     */
    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}