package com.toy.service.board;

import com.toy.dto.board.BoardRequestDto;
import com.toy.repository.board.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    
    private BoardRepository boardRepository;

    public void insertBoard(BoardRequestDto boardRequestDTO) {
        boardRepository.insertBoard(boardRequestDTO);
    }
}
