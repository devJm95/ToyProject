package com.toy.repository.board.custom;

import com.toy.dto.board.BoardDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepositoryCustom {

    List<BoardDto> selectAll();
}
