package com.vae.service.impl;

import com.vae.domain.LoginUser;
import com.vae.domain.ResponseResult;
import com.vae.domain.User;
import com.vae.service.LoginService;
import com.vae.utils.JwtUtil;
import com.vae.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author vleus
 * @date 2022年08月07日 22:47
 */
@Service
public class     LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {

        //AuthenticationManager authenticate进行用户认证
        Authentication usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        //获取认证结果
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        //如果认证通过，使用userid生成一个jwt jwt存入ResponseResult
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String id = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(id);
        //把完整的用户信息存入redis, userid作为key
        redisCache.setCacheObject("login:"+id,loginUser);
        Map<String,String> map =new HashMap<>();
        map.put("token", jwt);
        return new ResponseResult(200,"登录成功",map);
    }
}