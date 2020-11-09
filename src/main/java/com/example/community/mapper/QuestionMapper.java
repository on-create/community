package com.example.community.mapper;

import com.example.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title, description, time_create, time_modified, creator, tag)" +
            "values (#{title}, #{description}, #{timeCreate}, #{timeModified}, #{creator}, #{tag})")
    void create(Question question);
}