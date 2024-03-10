package com.toy.repository.board;

import com.toy.dto.board.BoardRequestDto;
import com.toy.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    void insertBoard(BoardRequestDto boardRequestDTO);
}
