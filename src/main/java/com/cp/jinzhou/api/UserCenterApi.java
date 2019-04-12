/**
 * 用户中心api，即登录和登录后，用户对自己账号相关操作
 */
package com.cp.jinzhou.api;

import com.cp.jinzhou.core.service.IUserService;
import com.cp.jinzhou.core.vo.TerseUser;
import com.cp.utils.ErrorDefine;
import com.cp.utils.JsonResult;
import com.cp.utils.MD5;
import com.cp.utils.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 供UI调用的用户相关api(ajax接口)，响应结构为JsonResult的json格式。<br>
 * JsonResult结构描述：<br>
 * {<br>
 * "errcode": 0, //int 0--成功,其它值由错误文件定义 <br>
 * "errmsg": "ok", //string 错误描述，当errcode=0时，该值为ok或空,当errcode=其它值，具体的错误信息由错误文件定义<br>
 * "data":  {} //Object 实际返回的数据，每个api不同，在各api中具体描述<br>
 * }<br>
 *
 */
@CrossOrigin
@Controller
@RequestMapping("/userCenter")
@Slf4j
public class UserCenterApi {
	@Autowired
    IUserService userService;

    /***
     * 登录系统，如果成功则返回当前用户的信息
     * data格式：<br>
     * {<br>
     *  "id":1,//用户id<br>
     *  "state":1,//用户状态 0--正常，只有该状态才能做相关的更新操作，1 已停用<br>
     *  "name"://用户名称/<br>
     *  "loginName":"test",//用户登录名<br>
     *  "loginIp":"119.23.77.32",//上一次登录的ip<br>
     *  "loginTime":"2018-11-1 18:00:00" //上一次登录时间<br>
     * }
     * @param role 角色id
     * @param name base64后的登录名
     * @param password md5(未加密的loginName+未加密的password+randStr)后的大写字符串
     * @param randStr md5的随机数
     */
    //测试账号及快速验证的url：/userCenter/login?role=0&name=emhlbmc=&password=8E79F13CCECF0DD3E09987E7FCFB05EC&randStr=test
	//randStr:test
    //超级管理员登录名:zheng, 密码:mytest, role:0。  name=emhlbmc=&password=8E79F13CCECF0DD3E09987E7FCFB05EC&randStr=test
    //商户登录名:merchant, 密码:mytest, role:10。 name=bWVyY2hhbnQ=&password=29D6AF5BB8783223E9AB79338615D0C1&randStr=test
    //代理商登录名:agent, 密码:mytest, role:11 。name=YWdlbnQ=&password=83A23F82C7804BADC026ABBB5780840C&randStr=test
    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(HttpServletRequest request,HttpSession httpSession, Map<String,
            Object> map)
    {
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("loginName"),
                request.getParameter("userPwd"));
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return new JsonResult();
        } catch (AuthenticationException e) {
            return new JsonResult(msg);
        }
    }
    /***
     * 登录系统，如果成功则返回当前用户的信息
     * data格式：无<br>
     * @param oldPassword md5(未加密的oldpassword+未加密的新password)后的大写字符串
     * @param password base64后的新密码
     */
    @RequestMapping("/modifyPwd")
    @ResponseBody
    public JsonResult modifyPwd(String oldPassword, String password, HttpSession httpSession)
    {	
    	System.out.println(oldPassword);
    	System.out.println(password);
    	System.out.println(MD5.toMd5Lower("mytesttest"));
		if (StrUtil.isBlank(oldPassword)) {
			return new JsonResult(ErrorDefine.OLD_PASSWORD_IS_EMPTY_ERR);
		}
			
		if (StrUtil.isBlank(password)) {
			return new JsonResult(ErrorDefine.PASSWORD_IS_EMPTY_ERR);
		}
			
    	TerseUser user=(TerseUser) httpSession.getAttribute("user");
        if (user==null) {
        	return new JsonResult(ErrorDefine.NOT_LOGIN_ERR);
        }
            
        if (user.getState() != "0") {
            return new JsonResult(ErrorDefine.USER_STATE_IS_ERR);
        }
        if (userService.modifyPwd(user.getId(), oldPassword, password)) {
        	return new JsonResult(ErrorDefine.OK);
        }
        	
        return new JsonResult(ErrorDefine.OLD_PASSWORD_IS_ERROR_ERR);
     }
    
    
    @RequestMapping("/loginOut")
    @ResponseBody
    public JsonResult loginOut(HttpSession httpSession) {
    	
    		httpSession.removeAttribute("user");
    	
    	 return new JsonResult(ErrorDefine.OK);
    }


    @RequiresPermissions("user:add")
    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(HttpServletRequest request,HttpSession httpSession, Map<String,
            Object> map)
    {

        return new JsonResult("OK");
    }

}
