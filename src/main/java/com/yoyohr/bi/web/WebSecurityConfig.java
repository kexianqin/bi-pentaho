package com.yoyohr.bi.web;

//import com.yoyohr.client.SaikuClient;
//import org.pentaho.di.core.auth.core.AuthenticationManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 用于设置账号密码的登录验证.
 * Created by Administrator on 2017/3/13.
 */
//@EnableWebSecurity
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    protected void configure (HttpSecurity http) throws Exception{
//        http
//            .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll()
//                .and()
//            .rememberMe()
//            .tokenValiditySeconds(86400);
//    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
//        auth
//            .inMemoryAuthentication()
//                .withUser("kexianqin").password("yp123456").roles("USER")
//                .and().withUser("jiangwenhua").password("yp123456").roles("MANAGER");
//    }
//}
