
package com.xten.op.springboot.dao.annotation;

import com.xten.op.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 使用注解的方式做数据库操作
 */
@Mapper
public interface UserAnnotationMapper {

    @Select("select * from user")
	List<User> list();

}
