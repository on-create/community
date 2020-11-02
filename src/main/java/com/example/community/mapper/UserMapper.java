package com.example.community.mapper;

import com.example.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,time_create,time_modified)" +
                    " values (#{name},#{accountId},#{token},#{timeCreate},#{timeModified})")
    void insert(User user);
}
