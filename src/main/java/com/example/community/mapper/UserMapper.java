package com.example.community.mapper;

import com.example.community.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,time_create,time_modified,bio,avatar_url)" +
            " values (#{name},#{accountId},#{token},#{timeCreate},#{timeModified},#{bio},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer creator);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name = #{name}, token = #{token}, time_modified = #{timeModified}, avatar_url = #{avatarUrl}, bio = #{bio} where account_id = #{accountId}")
    void update(User user);
}
