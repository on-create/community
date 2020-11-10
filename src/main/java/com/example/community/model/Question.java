package com.example.community.model;

import lombok.Data;
import java.util.Date;

@Data
public class Question {
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
}
