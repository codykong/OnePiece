package com.xten.op.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/9
 * Time: 下午2:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTestTest {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceTestTest.class);

    @Autowired
    ServiceTest serviceTest;

    @Test
    public void res() throws Exception {
        LOG.error(serviceTest.res());
    }

}