package com.doddd.shiro.config;

import com.doddd.shiro.entity.User;
import com.doddd.shiro.service.UserService;
import lombok.val;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: spring-boot-shiro
 * @description:
 * @author: doddd
 * @create: 2020-03-04 17:39
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        simpleAuthorizationInfo.addStringPermission(currentUser.getPermission());
        return simpleAuthorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getUser(token.getUsername());

        if (user == null) {
            return null;
        }
        // 密码认证
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
