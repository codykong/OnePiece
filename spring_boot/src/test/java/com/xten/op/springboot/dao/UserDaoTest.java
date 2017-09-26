package com.xten.op.springboot.dao;

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
 * Time: 下午8:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void list() throws Exception {
        List<User> users = userDao.list();
        System.out.println(users);
    }

}