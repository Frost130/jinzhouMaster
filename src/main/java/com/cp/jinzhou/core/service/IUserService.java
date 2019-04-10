package com.cp.jinzhou.core.service;

import com.cp.jinzhou.core.entity.LoginLog;
import com.cp.jinzhou.core.entity.User;
import com.cp.jinzhou.core.vo.TerseUser;
import com.cp.utils.ResultException;

public interface IUserService {

    /**
     * 登录系统
     * @param role 用户类型
     * @param loginNameBase64 base64后的登录名
     * @param passwordMd5 md5(loginName+password+randStr)后的大写字符串
     * @param randStr md5的随机数
     * @return 如果成功，则返回用户的简洁信息
     */
    public TerseUser login(Short role, String loginNameBase64, String passwordMd5, String randStr);
    /**
     * 修改密码
     * @param userId 用户id
     * @param oldPasswordMd5 md5(未加密的新password+未加密的oldpassword)后的大写字符串
     * @param passwordBase64 base64后的新密码
     * @return boolean
     */
    public boolean modifyPwd(int userId, String oldPasswordMd5, String passwordBase64);
    public LoginLog getLastLoginLog(int userId);
    /**
     * 记录登录日志
     * @param userId 用户id
     * @param ip 登录时的ip地址
     * @param ua 登录时客户端浏览器的版本号、类型
     */
    public void logLoginInfo(int userId, String ip, String ua);



    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return User实例
     */
    public abstract User getUser(int userId);

    /**
     * 验证用户名是否存在
     *
     * @param loginName 输入的用户名
     * @return 返回验证结果，存在或不符合用户名格式返回true
     */
    public abstract boolean isUsedLoginName(String loginName);

    /**
     *
     * @param userTypeId 用户类型
     * @param name 名称
     * @param loginName 登录名称
     * @param password 密码
     * @throws ResultException
     */
    public void addUser(Short userTypeId, String name, String loginName, String password)  throws ResultException;

}
