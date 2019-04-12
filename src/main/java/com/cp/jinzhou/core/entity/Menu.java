package com.cp.jinzhou.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tbl_menu", schema = "", catalog = "jinzhou")
public class Menu {
    private int id;
    private Integer parentId;
    private String menuName;
    private String state;
    private String ruter;
    private String Perms;
    private String icon;
    private Timestamp creatTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ParentId")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "MenuName")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "Ruter")
    public String getRuter() {
        return ruter;
    }

    public void setRuter(String ruter) {
        this.ruter = ruter;
    }

    @Basic
    @Column(name = "Perms")
    public String getPerms() { return Perms; }

    public void setPerms(String perms) { Perms = perms; }

    @Basic
    @Column(name = "Icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
    @Column(name = "UpdateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }



    public Menu() {
    }

    public Menu(int id, Integer parentId, String menuName, String state, String ruter, String perms, String icon, Timestamp creatTime, Timestamp updateTime) {
        this.id = id;
        this.parentId = parentId;
        this.menuName = menuName;
        this.state = state;
        this.ruter = ruter;
        Perms = perms;
        this.icon = icon;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                parentId.equals(menu.parentId) &&
                menuName.equals(menu.menuName) &&
                state.equals(menu.state) &&
                ruter.equals(menu.ruter) &&
                Perms.equals(menu.Perms) &&
                icon.equals(menu.icon) &&
                creatTime.equals(menu.creatTime) &&
                updateTime.equals(menu.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, menuName, state, ruter, Perms, icon, creatTime, updateTime);
    }
}
