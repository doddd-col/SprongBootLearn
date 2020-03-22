package com.doddd.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: spring-boot-shiro
 * @description:
 * @author: doddd
 * @create: 2020-03-04 17:49
 **/
@Configuration
public class ShiroConfig {

    /**
     * 1. 配置Realm (自定义类继承AuthorizingRealm)
     * 2. 配置SecurityManager
     * 3. 配置ShiroFilterFactoryBean
     */

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        filterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        // 添加shiro的内置过滤器
        /**
         *  anon    无需验证
         *  authc   必须验证
         *  user    必须拥有记住我功能
         *  perms   拥有对某个资源的授权
         *  role    拥有角色权限
         */
        Map<String ,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/add", "authc");
        filterChainDefinitionMap.put("/update", "authc");

        // 权限设置
        filterChainDefinitionMap.put("/add","perms[add]");
        filterChainDefinitionMap.put("/update","perms[update]");

        // 注销
        filterChainDefinitionMap.put("/logout", "logout");


        // 设置拦截
        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 设置登录页面
        filterFactoryBean.setLoginUrl("/toLogin");

        // 设置未授权页面
        filterFactoryBean.setUnauthorizedUrl("/noauthc");

        return filterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
