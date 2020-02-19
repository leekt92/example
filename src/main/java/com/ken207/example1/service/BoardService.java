package com.ken207.example1.service;

import com.ken207.example1.domain.Board;
import com.ken207.example1.dto.BoardReqDto;
import com.ken207.example1.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BoardService {

    @Autowired
    BoardRepository boardRepository;
    @Transactional
    public Long postBoard(BoardReqDto boardReqDto){
        /*
        Board board = Board.builder()
                .author(boardReqDto.getAuthor())
                .subject(boardReqDto.getSubject())
                .content(boardReqDto.getContent())
                .build();

         */
        Board board = Board.postBoard(boardReqDto.getAuthor(), boardReqDto.getSubject(), boardReqDto.getContent()
                , boardReqDto.getPassword());

        Board newBoard = boardRepository.save(board);
        return newBoard.getId();
    }
}
