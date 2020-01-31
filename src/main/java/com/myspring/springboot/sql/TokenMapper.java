package com.myspring.springboot.sql;

import com.myspring.springboot.bean.TokenBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TokenMapper {

    @Select("SELECT * FROM test_register_token WHERE token=${token}")
    TokenBean findId(String token);

    @Select("SELECT * FROM test_register_token WHERE id = ${id}")
    TokenBean findToken(Integer id);

    @Select("REPLACE INTO test_register_token VALUES (${id},${token})")
    String insertToken (@Param("id") String id, @Param("token") String token);

}
