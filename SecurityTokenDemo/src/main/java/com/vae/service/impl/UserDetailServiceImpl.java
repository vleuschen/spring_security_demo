package com.vae.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.vae.domain.LoginUser;
import com.vae.domain.User;
import com.vae.mapper.MenuMapper;
import com.vae.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author vleus
 * @date 2022年08月01日 22:47
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, userName);
        User user = userMapper.selectOne(queryWrapper);
        //若没有查询到用户就抛出异常
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或者密码错误!");
        }

        //TODO 查询对应的权限信息
//        List<String> permissions = new ArrayList<>(Arrays.asList(
//                "test","admin"
//        ));
        List<String> permissions = menuMapper.selectPermsByUserId(user.getId());
        //封装UserDetails对象并返回

        return new LoginUser(user,permissions);
    }
}