package com.toy.repository.board;

import com.toy.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    //void insertBoard();

    //List<BoardDto> getBaordList();
}
