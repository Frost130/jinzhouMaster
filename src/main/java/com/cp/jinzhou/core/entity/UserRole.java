package com.cp.jinzhou.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_user_role", schema = "", catalog = "jinzhou")
public class UserRole {
    private int id;
    private Integer userId;
    private Integer roleId;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UserId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "RoleId")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole that = (UserRole) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, roleId);
    }
}
