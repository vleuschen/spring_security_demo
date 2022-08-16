package com.vae.handler;

import com.alibaba.fastjson.JSON;
import com.vae.domain.ResponseResult;
import com.vae.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author vleus
 * @date 2022年08月16日 22:28
 * 如果是认证过程中出现的异常会被封装成AuthenticationException然后调用AuthenticationEntryPoint对象的方法去进行异常处理。
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //处理异常
        ResponseResult responseResult = new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"user auth failed,pls login again");
        String json = JSON.toJSONString(responseResult);
        WebUtils.renderString(response, json);
    }
}