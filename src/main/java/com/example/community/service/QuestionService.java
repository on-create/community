package com.example.community.service;

import com.example.community.dto.PaginationDTO;
import com.example.community.dto.QuestionDTO;
import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private QuestionMapper questionMapper;

    public PaginationDTO list(Integer page, Integer size) {
        //获取数据库中question数据的总条数
        Integer totalCount = questionMapper.count();
        //总页数
        Integer totalPage;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        //限制page
        if (page < 1) {
            page = 1;
        } else if (page > totalPage) {
            page = totalPage;
        }
        //数据库查找索引，page=1时从第一条开始
        Integer offset = size * (page - 1);

        //从数据库中查找部分question集合数据
        List<Question> questions = questionMapper.list(offset, size);
        //创建questionDTO集合对象
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        //创建分页部分question对象
        PaginationDTO paginationDTO = new PaginationDTO();

        //遍历questions
        for (Question question : questions) {
            //通过问题提交用户id查找用户
            User user = userMapper.findById(question.getCreator());
            //创建questionDTO对象
            QuestionDTO questionDTO = new QuestionDTO();
            //将question转换为questionDTO
            BeanUtils.copyProperties(question, questionDTO);
            //给questionDTO中的user属性赋值
            questionDTO.setUser(user);
            //将questionDTO添加进questionDTOS中
            questionDTOS.add(questionDTO);
        }

        //将questionDTO添加进paginationDTO中
        paginationDTO.setQuestions(questionDTOS);
        paginationDTO.setPagination(totalPage, page);
        return paginationDTO;
    }

    public PaginationDTO listByUserId(Integer userId, Integer page, Integer size) {
        //根据userId获取数据库中question数据的总条数
        Integer totalCount = questionMapper.countByUserId(userId);
        //总页数
        Integer totalPage;
        if (totalCount % size == 0 && totalCount != 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        //限制page
        if (page < 1) {
            page = 1;
        } else if (page > totalPage) {
            page = totalPage;
        }
        //数据库查找索引，page=1时从第一条开始
        Integer offset = size * (page - 1);

        //从数据库中查找部分question集合数据
        List<Question> questions = questionMapper.listByUserId(userId, offset, size);
        //创建questionDTO集合对象
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        //创建分页部分question对象
        PaginationDTO paginationDTO = new PaginationDTO();

        //遍历questions
        for (Question question : questions) {
            //通过问题提交用户id查找用户
            User user = userMapper.findById(question.getCreator());
            //创建questionDTO对象
            QuestionDTO questionDTO = new QuestionDTO();
            //将question转换为questionDTO
            BeanUtils.copyProperties(question, questionDTO);
            //给questionDTO中的user属性赋值
            questionDTO.setUser(user);
            //将questionDTO添加进questionDTOS中
            questionDTOS.add(questionDTO);
        }

        //将questionDTO添加进paginationDTO中
        paginationDTO.setQuestions(questionDTOS);
        paginationDTO.setPagination(totalPage, page);
        return paginationDTO;
    }
}
