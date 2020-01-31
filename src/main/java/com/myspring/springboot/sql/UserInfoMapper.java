package com.myspring.springboot.sql;

import com.myspring.springboot.bean.TestUserInfoBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

//    @Select("SELECT * FROM test_user")
    List<TestUserInfoBean> findAll();

    TestUserInfoBean findId(Integer id);

//    @Update("UPDATE test_user set name=#{name},age=#{age},info=#{info} WHERE id = #{id}")
    int updateAll(TestUserInfoBean userBean);//如果是传多个参数  可以整合类型，也可以使用@Param("xx")String xx,@Param("xx") String xx

//    @Insert("INSERT INTO test_user VALUES (id = #{id},name = #{name},age = #{age},info = #{info})")
    int insertAll(TestUserInfoBean userBean);

//    @Delete("DELETE FROM test_user WHERE id = #{id}")
    int deleteAll(String id);
}
