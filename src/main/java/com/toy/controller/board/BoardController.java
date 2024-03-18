package com.toy.controller.board;

import com.toy.dto.board.BoardDTO;
import com.toy.dto.board.BoardRequestDTO;
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
    public ResponseEntity insertBoard(@RequestBody BoardRequestDTO boardRequestDto){
        Board result = boardService.insertBoard(boardRequestDto);
        return ResponseEntity.ok().body(result);
    }

    // 게시판 조회
    // TODO : selectAll 제거 (rest api 기본원칙은 행위는 적지않음)
    @GetMapping
    public List<BoardDTO> getBaordList(){
        return boardService.getBaordList();
    }

    // selectOne
    @GetMapping("/{id}")
    public ResponseEntity getBoardOne(@PathVariable("id") Long id){
        Board result = boardService.boardOne(id);
        return ResponseEntity.ok().body(result);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity updateBoard(@PathVariable("id") Long id,
                                        @RequestBody BoardRequestDTO boardRequestDto){
        Board board = boardService.updateBoard(id, boardRequestDto);
        return ResponseEntity.ok().body(board);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBoardOne(@PathVariable("id") Long id){
        boardService.deleteBoardOne(id);
        return ResponseEntity.ok().build();
    }
}