package com.toy.repository.board.custom;

import com.toy.dto.board.BoardRequestDto;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepositoryCustom {

    void insertBoard(BoardRequestDto boardRequestDTO);
}
