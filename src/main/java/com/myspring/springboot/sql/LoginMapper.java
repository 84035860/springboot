package com.myspring.springboot.sql;

import com.myspring.springboot.bean.TestUserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginMapper {
    @Select("SELECT * FROM test_user")
    List<TestUserBean> findAll();

    @Select("SELECT * FROM test_user WHERE account = #{account}")
    TestUserBean findId(String account);
}
