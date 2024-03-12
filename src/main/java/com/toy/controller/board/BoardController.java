package com.toy.controller.board;

import com.toy.dto.board.BoardDto;
import com.toy.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    // insert
//    @PostMapping("/insert")
//    public String insertBoard() {
//        boardService.insertBoard();
//        return "Response는 뭘로?";
//    }

    // selectAll
    @GetMapping("/selectAll")
    public List<BoardDto> selectAll(){
        return boardService.selectAll();
    }

    // selectOne

    // update

}
