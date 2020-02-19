package com.ken207.example1.controller;

import com.ken207.example1.dto.BoardReqDto;
import com.ken207.example1.dto.BoardResDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/hello")
    public  String hello(){
        return "hello world";
    }

    @PostMapping
    public BoardResDto postBoard(@RequestBody BoardReqDto boardReqDto){
        return BoardResDto.builder()
                .author(boardReqDto.getAuthor())
                .subject(boardReqDto.getSubject())
                .content(boardReqDto.getContent())
                .build();
    }
    @PutMapping("/update")
    public String adjustBoard(){
        return  "";
    }
    @PutMapping("/delete")
    public String deleteBoard(){
        return  "";
    }

}
