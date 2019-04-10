package com.cp.jinzhou.core.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tbl_user", schema = "", catalog = "jinzhou")
public class TblUser {
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
        TblUser tblUser = (TblUser) o;
        return id == tblUser.id &&
                Objects.equals(userName, tblUser.userName) &&
                Objects.equals(userPwd, tblUser.userPwd) &&
                Objects.equals(state, tblUser.state) &&
                Objects.equals(loginName, tblUser.loginName) &&
                Objects.equals(createTime, tblUser.createTime) &&
                Objects.equals(remark, tblUser.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPwd, state, loginName, createTime, remark);
    }
}
