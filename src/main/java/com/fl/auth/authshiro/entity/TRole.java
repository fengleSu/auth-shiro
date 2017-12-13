package com.fl.auth.authshiro.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_role")
public class TRole {
    /**
     * 主键
     */
    @Column(name = "n_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nId;

    /**
     * 角色名称
     */
    @Column(name = "c_role_name")
    private String cRoleName;

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
     * 获取角色名称
     *
     * @return c_role_name - 角色名称
     */
    public String getcRoleName() {
        return cRoleName;
    }

    /**
     * 设置角色名称
     *
     * @param cRoleName 角色名称
     */
    public void setcRoleName(String cRoleName) {
        this.cRoleName = cRoleName;
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