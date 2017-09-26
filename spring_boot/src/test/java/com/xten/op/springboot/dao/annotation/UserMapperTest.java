package com.xten.op.springboot.dao.annotation;

import com.xten.op.springboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/11
 * Time: 下午8:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserAnnotationMapper userMapper;

    @Test
    public void list() throws Exception {
        List<User> users = userMapper.list();
        System.out.println(users);
    }

}