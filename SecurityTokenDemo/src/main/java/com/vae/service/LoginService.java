package com.vae.service;

import com.vae.domain.ResponseResult;
import com.vae.domain.User;

public interface LoginService {

    ResponseResult login(User user);
}
