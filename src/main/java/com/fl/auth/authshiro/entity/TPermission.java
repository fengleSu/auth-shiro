package com.fl.auth.authshiro.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_permission")
public class TPermission {
    /**
     * 主键id
     */
    @Column(name = "n_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nId;

    /**
     * 权限
     */
    @Column(name = "c_permission")
    private String cPermission;

    /**
     * 权限名称
     */
    @Column(name = "c_permission_name")
    private String cPermissionName;

    /**
     * 访问路径
     */
    private String url;

    /**
     * 父权限
     */
    @Column(name = "n_parent")
    private Integer nParent;

    /**
     * 排序
     */
    @Column(name = "n_sequence")
    private Integer nSequence;

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
     * 获取权限
     *
     * @return c_permission - 权限
     */
    public String getcPermission() {
        return cPermission;
    }

    /**
     * 设置权限
     *
     * @param cPermission 权限
     */
    public void setcPermission(String cPermission) {
        this.cPermission = cPermission;
    }

    /**
     * 获取权限名称
     *
     * @return c_permission_name - 权限名称
     */
    public String getcPermissionName() {
        return cPermissionName;
    }

    /**
     * 设置权限名称
     *
     * @param cPermissionName 权限名称
     */
    public void setcPermissionName(String cPermissionName) {
        this.cPermissionName = cPermissionName;
    }

    /**
     * 获取访问路径
     *
     * @return url - 访问路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置访问路径
     *
     * @param url 访问路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取父权限
     *
     * @return n_parent - 父权限
     */
    public Integer getnParent() {
        return nParent;
    }

    /**
     * 设置父权限
     *
     * @param nParent 父权限
     */
    public void setnParent(Integer nParent) {
        this.nParent = nParent;
    }

    /**
     * 获取排序
     *
     * @return n_sequence - 排序
     */
    public Integer getnSequence() {
        return nSequence;
    }

    /**
     * 设置排序
     *
     * @param nSequence 排序
     */
    public void setnSequence(Integer nSequence) {
        this.nSequence = nSequence;
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