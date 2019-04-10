package com.cp.jinzhou.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_role", schema = "", catalog = "jinzhou")
public class Role {
    private int id;
    private String roleName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role that = (Role) o;
        return id == that.id &&
                Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName);
    }
}
