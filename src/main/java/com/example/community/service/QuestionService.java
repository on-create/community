package com.example.community.service;

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

    public List<QuestionDTO> list() {
        //查找question对象
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOS = new ArrayList<QuestionDTO>();

        //遍历questions
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            //将question转换为questionDTO
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            //将questionDTO添加进questionDTOS中
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }
}
