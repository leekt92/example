package com.ken207.example1.controller;

import com.ken207.example1.domain.Board;
import com.ken207.example1.dto.BoardReqDto;
import com.ken207.example1.dto.BoardResDto;
import com.ken207.example1.exception.BizRuntimeException;
import com.ken207.example1.repository.BoardRepository;
import com.ken207.example1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/hello/{boardId}")
    public  BoardResDto read(@PathVariable Long boardId)
    {
        Optional<Board> boardOptional = boardRepository.findById(boardId);

        if(!boardOptional.isPresent()){
            throw new BizRuntimeException("ID입력");
        }

        Board board = boardOptional.get();
        return BoardResDto.builder()
                .id(board.getId())
                .author(board.getAuthor())
                .subject(board.getSubject())
                .content(board.getContent())
                .passWord(board.getPassword())
                .createdTime(board.getCreatedTime())
                .modifiedDate(board.getModifiedDate())
                .hitCount(board.getHitCount())
                .delYn(board.isDelYn())
                .build();
    }

    @PostMapping
    public BoardResDto postBoard(@RequestBody BoardReqDto boardReqDto){
        Long boardId = boardService.postBoard(boardReqDto);

        Optional<Board> boardOptional = boardRepository.findById(boardId);

        /* null체크
        if(boardOptional.isPresent()){
            Board board = boardOptional.get();
        }
        */
        Board board = boardRepository.findById(boardId).get();

        return BoardResDto.builder()
                .id(board.getId())
                .author(boardReqDto.getAuthor())
                .subject(boardReqDto.getSubject())
                .content(boardReqDto.getContent())
                .passWord(boardReqDto.getPassword())
                .createdTime(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .hitCount(0)
                .delYn(false)
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
