package com.ken207.example1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Board {
    @Id
    @GeneratedValue
    private long id;

    private  String author;
    private  String subject;
    private  String content;
    private  LocalDateTime createdTime;

}
