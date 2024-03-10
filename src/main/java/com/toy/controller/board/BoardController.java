package com.toy.controller.board;

import com.toy.dto.board.BoardRequestDto;
import com.toy.service.board.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    // insert
    @PostMapping
    public String insertBoard(@RequestBody BoardRequestDto boardRequestDTO) {
        boardService.insertBoard(boardRequestDTO);
        return "Response는 뭘로?";
    }

    // selectAll

    // selectOne

    // update

}
