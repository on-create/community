package com.example.community.dto;

import com.example.community.model.User;
import lombok.Data;

import java.util.Date;
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Date timeCreate;
    private Date timeModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
