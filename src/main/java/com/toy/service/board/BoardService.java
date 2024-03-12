package com.toy.service.board;

import com.toy.dto.board.BoardDto;
import com.toy.entity.board.Board;
import com.toy.repository.board.BoardRepository;
import com.toy.repository.board.BoardRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepositoryCustom boardRepositoryCustom;

    public List<BoardDto> selectAll() {
        // TODO : 여기서 entity를 DTO화해서 리턴하게 수정하기
        return boardRepositoryCustom.selectAll();
    }
}
