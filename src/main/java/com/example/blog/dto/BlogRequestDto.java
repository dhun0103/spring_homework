package com.example.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BlogRequestDto {
    private String title;
    private String username;
    private String password;
    private String contents;

    public BlogRequestDto(String title, String username, String password, String contents){
        this.title = title;
        this.username = username;
        this.password = password;
        this.contents = contents;
    }
}
