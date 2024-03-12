package com.toy.repository.board.custom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.dto.board.BoardDto;
import com.toy.dto.board.QBoardDto;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.toy.entity.board.QBoard.board;

@Repository
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory qF;

    public BoardRepositoryCustomImpl(EntityManager em){
        this.qF = new JPAQueryFactory(em);
    }

    @Override
    public List<BoardDto> selectAll() {
        return qF.
                select(new QBoardDto(
                        board.boardId,
                        board.content,
                        board.title,
                        board.cDate,
                        board.uDate)).
                from(board).
                fetch();
    }
}
