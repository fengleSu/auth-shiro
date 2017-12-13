package com.fl.auth.authshiro.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_role_permission")
public class TRolePermission {
    /**
     * 主键id
     */
    @Column(name = "n_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nId;

    /**
     * 角色id
     */
    @Column(name = "n_role_id")
    private Integer nRoleId;

    /**
     * 权限id
     */
    @Column(name = "n_permission_id")
    private Integer nPermissionId;

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
    private Boolean isDelete;

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
     * 获取权限id
     *
     * @return n_permission_id - 权限id
     */
    public Integer getnPermissionId() {
        return nPermissionId;
    }

    /**
     * 设置权限id
     *
     * @param nPermissionId 权限id
     */
    public void setnPermissionId(Integer nPermissionId) {
        this.nPermissionId = nPermissionId;
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