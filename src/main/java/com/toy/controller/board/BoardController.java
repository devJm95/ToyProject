package com.toy.controller.board;

import com.toy.dto.board.BoardDto;
import com.toy.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // insert
//    @PostMapping
//    public BoardResponseDto insertBoard(BoardRequestDto boardRequestDto){
//        return boardService.insertBoard(boardDto);
//    }

    // selectAll
    // TODO : selectAll 제거 (rest api 기본원칙은 행위는 적지않음)
    @GetMapping
    public List<BoardDto> selectAll(){
        return boardService.selectAll();
    }

    // selectOne
//    @GetMapping("${id}")
//    public List<BoardDto> selectAll(@PathVariable("id") int id){
//        return boardService.selectOne(id);
//    }

    // update
//    @PutMapping
//    public BoardResponseDto insertBoard(BoardRequestDto boardRequestDto){
//        return boardService.insertBoard(boardDto);
//    }
}
