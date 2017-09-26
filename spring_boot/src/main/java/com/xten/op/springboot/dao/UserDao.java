package com.xten.op.springboot.dao;

import com.xten.op.springboot.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 使用xml方式,及sqlSession 进行数据操作
 * User: kongqingyu
 * Date: 2017/1/11
 * Time: 下午8:40
 */
@Component
public class UserDao {

    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    List<User> list(){
        return sqlSession.selectList("list");
    }


}
