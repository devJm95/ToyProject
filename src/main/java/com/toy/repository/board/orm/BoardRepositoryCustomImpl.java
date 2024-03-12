package com.toy.repository.board.orm;

import com.toy.dto.board.BoardDto;
import com.toy.dto.board.QBoardDto;
import com.toy.repository.board.BoardRepositoryCustom;
import org.springframework.stereotype.Repository;

import static com.querydsl.jpa.JPAExpressions.select;
import static com.toy.entity.board.QBoard.board;

import java.util.List;

@Repository
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom {

    // TODO : 여기서는 entity자체를 리턴하고 service에서 DTO화해서 리턴하게 수정하기
    @Override
    public List<BoardDto> selectAll() {
        return select(new QBoardDto(
                        board.boardId,
                        board.content,
                        board.title,
                        board.cDate,
                        board.uDate)).
                from(board).
                fetch();
    }
}
