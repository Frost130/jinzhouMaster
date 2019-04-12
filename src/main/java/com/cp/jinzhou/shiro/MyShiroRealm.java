package com.cp.jinzhou.shiro;

import com.cp.jinzhou.core.entity.Menu;
import com.cp.jinzhou.core.entity.Role;
import com.cp.jinzhou.core.entity.RoleMenu;
import com.cp.jinzhou.core.entity.UserRole;
import com.cp.jinzhou.core.service.*;
import com.cp.jinzhou.core.vo.TerseUser;
import com.cp.utils.StrUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService IUserService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IRoleMenuService roleMenuService;
    @Autowired
    private IUserRoleService userRoleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        System.out.println(SecurityUtils.getSubject().getPrincipal());
        TerseUser userInfo  = (TerseUser) SecurityUtils.getSubject().getPrincipal();
        List<UserRole> userRoleList=userRoleService.findAll(userInfo.getId());
        for(UserRole userRole:userRoleList){
            List<Role> roleList=roleService.findById(userRole.getRoleId());
            for (Role role:roleList){
                authorizationInfo.addRole(role.getRoleSign());
                List<RoleMenu> roleMenuList=roleMenuService.findAll(role.getId());
                for(RoleMenu roleMenu:roleMenuList){
                    List<Menu> menuList=menuService.findById(roleMenu.getMenuId());
                    for(Menu menu:menuList){
                        if(null!=menu.getPerms()&&StrUtil.isNotEmpty(menu.getPerms())){
                            authorizationInfo.addStringPermission(menu.getPerms());
                        }

                    }
                }
            }
        }
        System.out.println("OK");
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        Map<String, Object> map = new HashMap<>(16);
        map.put("username", username);
        String password = new String((char[]) token.getCredentials());

        System.out.println(username+"+"+password);
        // 查询用户信息
        TerseUser user = IUserService.login(username,password);

        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        // 账号锁定
        if (user.getState() == "1") {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        user.setLoginTime(new Date());
        //user.setLoginIp(SessionUtils.getVistorIp(request));
        System.out.println();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        System.out.println(info);
        return info;
    }

}
