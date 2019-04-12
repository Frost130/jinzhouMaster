package com.cp.jinzhou.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tbl_user", schema = "", catalog = "jinzhou")
public class User {
    private int id;
    private String userName;
    private String userPwd;
    private String state;
    private String loginName;
    private Timestamp createTime;
    private String remark;


    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UserName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "UserPwd")
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
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
    @Column(name = "LoginName")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "CreateTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "Remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userPwd, user.userPwd) &&
                Objects.equals(state, user.state) &&
                Objects.equals(loginName, user.loginName) &&
                Objects.equals(createTime, user.createTime) &&
                Objects.equals(remark, user.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPwd, state, loginName, createTime, remark);
    }

    public User() {
    }

    public User(int id, String userName, String userPwd, String state, String loginName, Timestamp createTime, String remark) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.state = state;
        this.loginName = loginName;
        this.createTime = createTime;
        this.remark = remark;
    }
}
