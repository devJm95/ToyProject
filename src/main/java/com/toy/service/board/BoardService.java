package com.toy.service.board;

import com.toy.dto.board.BoardDto;
import com.toy.entity.board.Board;
import com.toy.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardDto> selectAll() {
        return boardRepository.selectAll();
    }
}
