package com.toy.controller.board;

import com.toy.dto.board.BoardDTO;
import com.toy.dto.board.BoardRequestDTO;
import com.toy.dto.board.BoardResponseDto;
import com.toy.entity.board.Board;
import com.toy.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


     //insert
    @PostMapping
    public ResponseEntity insertBoard(@RequestBody BoardDTO boardDto){
        Board result = boardService.insertBoard(boardDto);
        return ResponseEntity.ok().body(result);
    }

    // 게시판 조회
    // TODO : selectAll 제거 (rest api 기본원칙은 행위는 적지않음)
    @GetMapping
    public List<BoardDTO> getBaordList(){
        return boardService.getBaordList();
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
