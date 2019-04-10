package com.cp.jinzhou.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_menu", schema = "", catalog = "jinzhou")
public class Menu {
    private int id;
    private String menuName;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MenuName")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu that = (Menu) o;
        return id == that.id &&
                Objects.equals(menuName, that.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuName);
    }
}
