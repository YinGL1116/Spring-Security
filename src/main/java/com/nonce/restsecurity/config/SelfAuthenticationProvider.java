package com.nonce.restsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Andon
 * @date 2019/3/20
 * <p>
 * 登录认证
 */
@Slf4j
@Component
public class SelfAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private SelfUserDetailsService selfUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = (String) authentication.getPrincipal(); //表单输入的用户名
        String password = (String) authentication.getCredentials(); //表单输入的密码

        UserDetails userInfo = selfUserDetailsService.loadUserByUsername(username);

        log.info("input password: {}", password);
        log.info("userInfo: {}", userInfo.toString());

        boolean matches = new BCryptPasswordEncoder().matches(password, userInfo.getPassword());
        //boolean matches = password.equals(userInfo.getPassword());
        log.info("match password: {}", matches);
        if (!matches) {
            throw new BadCredentialsException("The password is incorrect!!");
        }

        return new UsernamePasswordAuthenticationToken(username, userInfo.getPassword(), userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
