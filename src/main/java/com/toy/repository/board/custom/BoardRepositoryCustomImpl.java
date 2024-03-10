package com.toy.repository.board.custom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.dto.board.BoardRequestDto;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory qF;

    public BoardRepositoryCustomImpl(EntityManager em){
        this.qF = new JPAQueryFactory(em);
    }

    @Override
    public void insertBoard(BoardRequestDto boardRequestDTO) {
        //qF.insert().columns();
    }
}
