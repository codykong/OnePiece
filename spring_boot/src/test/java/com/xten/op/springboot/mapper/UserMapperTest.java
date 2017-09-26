package com.xten.op.springboot.mapper;

import com.xten.op.springboot.model.User;
import com.xten.op.springboot.service.ServiceTestTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/9
 * Time: 下午5:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceTestTest.class);

    @Autowired
    UserMapper userMapper;

    @Test
    public void list() throws Exception {
        System.out.println();
        List<User>  users = userMapper.list();
        LOG.info(users.toString());
    }

}