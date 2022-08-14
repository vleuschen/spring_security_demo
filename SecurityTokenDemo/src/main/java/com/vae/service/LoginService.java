package com.vae.service;

import com.vae.domain.ResponseResult;
import com.vae.domain.User;

public interface LoginService {

    //登录接口
    ResponseResult login(User user);

    ResponseResult logout();
}
