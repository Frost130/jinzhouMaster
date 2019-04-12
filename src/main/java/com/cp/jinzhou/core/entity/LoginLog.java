package com.cp.jinzhou.core.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class LoginLog {
    private int id;
    private Integer userId;
    private String loginIp;
    private Timestamp loginTime;
    private String ua;

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
    @Column(name = "LoginIp")
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Basic
    @Column(name = "LoginTime")
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "Ua")
    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginLog loginlog = (LoginLog) o;
        return id == loginlog.id &&
                Objects.equals(userId, loginlog.userId) &&
                Objects.equals(loginIp, loginlog.loginIp) &&
                Objects.equals(loginTime, loginlog.loginTime) &&
                Objects.equals(ua, loginlog.ua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, loginIp, loginTime, ua);
    }

    public LoginLog(int id, Integer userId, String loginIp, Timestamp loginTime, String ua) {
        this.id = id;
        this.userId = userId;
        this.loginIp = loginIp;
        this.loginTime = loginTime;
        this.ua = ua;
    }

    public LoginLog(int id) {
        this.id = id;
    }

    public LoginLog(int id, String loginIp, String ua) {
        this.id = id;
        this.loginIp = loginIp;
        this.ua = ua;
    }
}
