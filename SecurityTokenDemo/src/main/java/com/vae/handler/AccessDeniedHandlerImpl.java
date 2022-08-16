package com.vae.handler;

import com.alibaba.fastjson.JSON;
import com.vae.domain.ResponseResult;
import com.vae.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author vleus
 * @date 2022年08月16日 22:34
 * 如果是授权过程中出现的异常会被封装成AccessDeniedException,
 * 然后调用AccessDeniedHandler对象的方法去进行异常处理。
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        ResponseResult responseResult = new ResponseResult(HttpStatus.FORBIDDEN.value(),"user have not the access");
        String json = JSON.toJSONString(responseResult);
        WebUtils.renderString(response, json);

    }
}