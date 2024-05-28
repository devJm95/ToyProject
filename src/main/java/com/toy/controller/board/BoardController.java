package com.toy.controller.board;

import com.toy.dto.board.BoardDTO;
import com.toy.dto.board.BoardRequestDTO;
import com.toy.entity.board.Board;
import com.toy.service.board.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Board API")
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    @Operation(summary = "Board 등록", description = "게시판 정보를 등록합니다")
    public ResponseEntity insertBoard(@RequestBody BoardRequestDTO boardRequestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // 인증된 사용자의 이름을 가져옴
        boardRequestDto.setUserId(username); // 사용자 아이디 대신 이름으로
        Board result = boardService.insertBoard(boardRequestDto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    @Operation(summary = "Board List 조회", description = "게시판 리스트를 조회합니다")
    public List<BoardDTO> getBaordList(){
        return boardService.getBaordList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Board One 조회", description = "게시글 1개를 조회합니다")
    public ResponseEntity getBoardOne(@PathVariable("id") Long id){
        Board result = boardService.boardOne(id);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Board Update", description = "게시판 정보를 수정합니다")
    public ResponseEntity updateBoard(@PathVariable("id") Long id,
                                        @RequestBody BoardRequestDTO boardRequestDto){
        Board board = boardService.updateBoard(id, boardRequestDto);
        return ResponseEntity.ok().body(board);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Board Delete", description = "게시판 정보를 삭제합니다")
    public ResponseEntity deleteBoardOne(@PathVariable("id") Long id){
        boardService.deleteBoardOne(id);
        return ResponseEntity.ok().build();
    }
}