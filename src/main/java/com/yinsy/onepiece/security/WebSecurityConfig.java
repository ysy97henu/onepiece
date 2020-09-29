package com.yinsy.onepiece.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * // TODO
     * 继承WebSecurityConfigurerAdapter可以选择实现该类中的三个重载的configure方法
     * <p>
     * 1. configure
     * 入参: AuthenticationManagerBuilder
     * 作用: 用于通过允许AuthenticationProvider容易地添加来建立认证机制。也就是说用来记录账号，密码，角色信息。
     * <p>
     * 2. configure
     * 入参: HttpSecurity
     * 作用: 允许基于选择匹配在资源级配置基于网络的安全性。
     * <p>
     * 3. configure
     * 入参: WebSecurity
     * 作用: 用于影响全局安全性(配置资源，设置调试模式，通过实现自定义防火墙定义拒绝请求)的配置设置。一般用于配置全局的某些通用事物，例如静态资源等
     */

    /**
     *
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 内存验证
//        auth.inMemoryAuthentication()
//                // 配置密码加密方式
//                .passwordEncoder(new BCryptPasswordEncoder())
//                // 配置用户名密码
//                .withUser("user")
//                .password(new BCryptPasswordEncoder().encode("123456"))
//                // 配置角色信息
//                .roles("USER");
    }

    /**
     * 登录认证及资源访问权限 自定义配置
     *
     * @param http ???这个参数是他妈啥啊 知识盲区 现在还不知道
     * @throws Exception
     * @author yinsongyuan
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 不重写默认配置
//        http
//                .authorizeRequests()
//        // 允许用户使用HTTP基于验证进行认证
//                .anyRequest().authenticated()
//                .and()
//        // 允许用户进行基于表单的认证
//                .formLogin()
//                .and()
//        // 允许用户使用HTTP基于验证进行认证
//                .httpBasic();

        /**
         * 一些目前使用不到的使用注释
         *
         * csrf() 相关
         *  csrf().disable() 禁用跨站csrf攻击
         */

        /**
         * 常用配置：
         *  验证请求:
         *   antMatchers 添加过滤URL
         *      permitAll() 全部可通过
         */
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/demo/first", "/auth/**", "/user/login").anonymous()
//                .antMatchers(HttpMethod.POST,"/user/login").permitAll()
                .anyRequest().authenticated().and()
                .httpBasic();

    }
//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("123456"));
//    }
}
