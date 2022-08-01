package com.vae;

import com.vae.domain.User;
import com.vae.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}