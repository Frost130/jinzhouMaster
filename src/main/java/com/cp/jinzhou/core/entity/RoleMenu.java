package com.cp.jinzhou.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_role_menu", schema = "", catalog = "jinzhou")
public class RoleMenu {
    private int id;
    private Integer roleId;
    private Integer menuId;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "RoleId")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "MenuId")
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleMenu roleMenu = (RoleMenu) o;
        return id == roleMenu.id &&
                Objects.equals(roleId, roleMenu.roleId) &&
                Objects.equals(menuId, roleMenu.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, menuId);
    }
}
