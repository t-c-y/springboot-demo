package com.tcy.mapper;

import com.tcy.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * " +
            "from user ")
    List<User> listUser();

    @Select("select * " +
            "from user " +
            "where id = #{id}")
    User getUserById(@Param("id") Long id);

    @Insert("insert into user " +
            "(name, age) " +
            "values " +
            "(#{name}, #{age}) ")
    int saveUser(User user);

    @Update("update user " +
            "set name = #{name}," +
            "    age = #{age} " +
            "where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int removeUser(@Param("id") Long id);

}
