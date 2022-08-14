package com.vae.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vleus
 * @date 2022年07月27日 22:47
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test3')")
    public String hello() {
        return "Hello,Spring Security!";
    }
}