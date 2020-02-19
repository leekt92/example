package com.ken207.example1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BoardResDto {

    private  String author;
    private  String subject;
    private  String content;
    private  LocalDateTime createdTime;
    private  LocalDateTime modifiedDate;
    private  int hitCount;
    private  boolean delYn;
    private  String password;

}
