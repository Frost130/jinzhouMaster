package com.cp.jinzhou.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tbl_role", schema = "", catalog = "jinzhou")
public class Role {
    private int id;
    private String roleName;
    private String remark;
    private String roleSign;
    private String createUser;
    private Timestamp creatTime;
    private Timestamp update;
    private String state;


    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "RoleName")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "Remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "RoleSign")
    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    @Basic
    @Column(name = "CreateUser")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "CreatTime")
    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    @Basic
    @Column(name = "Update")
    public Timestamp getUpdate() {
        return update;
    }

    public void setUpdate(Timestamp update) {
        this.update = update;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(remark, role.remark) &&
                Objects.equals(roleSign, role.roleSign) &&
                Objects.equals(createUser, role.createUser) &&
                Objects.equals(creatTime, role.creatTime) &&
                Objects.equals(update, role.update) &&
                Objects.equals(state, role.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, remark, roleSign, createUser, creatTime, update, state);
    }

    public Role() {
    }

    public Role(int id, String roleName, String remark, String roleSign, String createUser, Timestamp creatTime, Timestamp update, String state) {
        this.id = id;
        this.roleName = roleName;
        this.remark = remark;
        this.roleSign = roleSign;
        this.createUser = createUser;
        this.creatTime = creatTime;
        this.update = update;
        this.state = state;
    }
}
