package com.nonce.restsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1登录（根据所登录用户所具有的权限返回给前端JSON数据，动态的展示功能菜单）。
 * 2注销。
 * 3动态拦截url请求，根据当前登录用户所具有的权限，进行权限认证（防止不具有权限的用户直接通过url请求功能）。
 * 4用户管理模块（查询所有用户[分页加模糊查询]、新增用户、修改用户、删除用户、为用户分配角色）。
 * 5角色管理模块（查询所有角色[分页加模糊查询]、新增角色、修改角色、删除角色、为角色分配可访问的资源菜单）。
 * 6菜单管理模块（查询所有菜单、新增菜单、修改菜单、删除菜单）。
 */
@SpringBootApplication
public class RestSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestSecurityApplication.class, args);
    }

}
