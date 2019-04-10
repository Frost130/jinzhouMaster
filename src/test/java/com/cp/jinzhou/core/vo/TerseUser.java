package com.cp.jinzhou.core.vo;


import com.cp.jinzhou.core.entity.User;

import java.util.Date;

/**
 * 用户类的简洁版类
 * Description: 一般用在保存session,及返还给前端
 */
public class TerseUser {
	private int id;
    private String state;
    private String name;
    private String loginName;
    private String loginIp;
    private Date loginTime;
   	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
    
    public TerseUser(User user)
    {
        if(user==null) {
        	return;
        }
            
        id=user.getId();
        loginName=user.getLoginName();
        state=user.getState();
    }
    public TerseUser()
    {
        
    }
	public TerseUser(TerseUser user) {
        id=user.getId();
        loginName=user.getLoginName();
        state=user.getState();
        loginIp=user.getLoginIp();
        loginTime=user.getLoginTime();
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}


    
}