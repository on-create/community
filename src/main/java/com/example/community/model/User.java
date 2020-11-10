package com.example.community.model;

import lombok.Data;
import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Date timeCreate;
    private Date timeModified;
    private String bio;
    private String avatarUrl;
}
