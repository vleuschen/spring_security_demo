package com.vae;

import com.vae.domain.User;
import com.vae.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vleus
 * @date 2022年08月01日 22:42
 */
@SpringBootTest
public class MapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testUserMapper() {

        List<User> users = userMapper.selectList(null);
        System.out.println(users);

    }

    @Test
    public void testBCryptPasswordEncoder() {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode1 = bCryptPasswordEncoder.encode("123456");
        String encode2 = bCryptPasswordEncoder.encode("123456");

        System.out.println(encode1);
        System.out.println(encode2);

        boolean matches = bCryptPasswordEncoder.matches("123456", "$2a$10$rFs3owudJuhfJH9GyVdnuO3Ai3lpfPIcRQECa7pJU7a.oJMsNpY.G");

        System.out.println(matches);

    }

}