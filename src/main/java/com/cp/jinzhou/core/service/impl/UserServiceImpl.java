package com.cp.jinzhou.core.service.impl;

import com.cp.jinzhou.core.dao.ILoginLogDao;
import com.cp.jinzhou.core.dao.IUserDao;
import com.cp.jinzhou.core.entity.LoginLog;
import com.cp.jinzhou.core.entity.User;
import com.cp.jinzhou.core.vo.TerseUser;
import com.cp.jinzhou.core.service.IUserService;
import com.cp.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    // 用户相关操作dao
    @Autowired
    private IUserDao userDao;
    @Autowired
    private ILoginLogDao loginLogDao;

    @Value("${crypto-key}")
    private String cryptoKey;
    private Lock lock=new ReentrantLock();


    /**
     * 登录系统
     *
     * @param loginNameBase64 base64后的登录名
     * @param passwordMd5     md5(loginName+password+randStr)后的大写字符串
     * @param randStr         md5的随机数
     * @return 如果成功，则返回用户的简洁信息
     */
    @Override
    public TerseUser login(Short role, String loginNameBase64, String passwordMd5, String randStr) {
        //log.info("login[role:"+role+",loginNameBase64:"+loginNameBase64+",passwordMd5:"+passwordMd5+",randStr:"+randStr+"]");
        // 解密 loginName and password
        String loginName = Base64.decode(loginNameBase64);
        if (StrUtil.isEmpty(loginName)) {
            return null;
        }

        User user = decryptPwd(userDao.findByLoginNameAndState(loginName, "0"));
        System.err.println(user.getUserName());

            if (MD5.toMd5Lower(user.getLoginName() + user.getUserPwd() + randStr).equals(passwordMd5)) {
                System.err.println(user.getUserName());
                TerseUser terseUser=new TerseUser();
                terseUser.setId(user.getId());
                terseUser.setName(user.getUserName());
                terseUser.setState(user.getState());
                terseUser.setLoginName(user.getLoginName());
                return terseUser;
            }
        return null;
    }

    /**
     * 修改密码
     * @param userId 用户id
     * @param oldPasswordMd5 md5(未加密的oldpassword+未加密的新password)后的大写字符串
     * @param passwordBase64 base64后的新密码
     * @return boolean
     */
    @Override
    public boolean modifyPwd(int userId,String oldPasswordMd5,String passwordBase64)
    {
        User user=decryptPwd(userDao.findById(userId));
        if (user==null) {
            return false;
        }
        System.out.println();
        String newPwd=Base64.decode(passwordBase64);
        System.out.println(newPwd);
        System.out.println(user.getUserPwd());
        if (MD5.toMd5Lower(user.getUserPwd()+newPwd ).equals(oldPasswordMd5)) {
            user.setUserPwd(newPwd);
            return userDao.updatePassword(user.getId(),encryptPwd(user).getUserPwd())==1;
        }
        return false;
    }
    /**
     * 记录登录日志
     * @param userId 用户id
     * @param ip 登录时的ip地址
     * @param ua 登录时客户端浏览器的版本号、类型
     */
    @Override
    public void logLoginInfo(int userId, String ip, String ua) {
        // TODO Auto-generated method stub

        loginLogDao.save(new LoginLog(userId, ip, ua));

    }

    @Override
    public void addUser( Short userTypeId,String name,String loginName, String password ) throws ResultException {


    }

    /*
     * (non-Javadoc)
     *
     * @see org.qianyuan.core.service.impl.IUserService#getUser(java.lang.Long)
     */
    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return User实例
     */
    @Override
    public User getUser(int userId) {
        if (userId == 0) {
            return null;
        }

        return userDao.findById(userId);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.qianyuan.core.service.impl.IUserService#isUsedLoginName(java.lang
     * .String)
     */
    /**
     * 验证用户名是否存在
     *
     * @param loginName 输入的用户名
     * @return 返回验证结果，存在或不符合用户名格式返回true
     */
    @Override
    public boolean isUsedLoginName(String loginName) {
        if (!Validation.isValidLoginName(loginName)) {
            return true;
        }

        return userDao.existsByLoginName(loginName);
    }

    @Override
    public LoginLog getLastLoginLog(int userId) {
        return loginLogDao.findFirstByUserIdOrderByIdDesc(userId);
    }

    private User encryptPwd(User user) {
        if (user==null) {
            return null;
        }

        user.setUserPwd(Validation.encryptPassword(user.getUserPwd(), user.getLoginName(), cryptoKey));
        return user;
    }

    private User decryptPwd(User user) {
        if(user==null) {
            return null;
        }

        user.setUserPwd(Validation.decryptPassword(user.getUserPwd(), user.getLoginName(), cryptoKey));
        return user;
    }



}
