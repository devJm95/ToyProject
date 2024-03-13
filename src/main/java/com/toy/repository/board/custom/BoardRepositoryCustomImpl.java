package com.toy.repository.board.custom;

import org.springframework.stereotype.Repository;

@Repository
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom{


//    @Override
//    public List<BoardDto> getBaordList() {
//        return select(new QBoardDto(
//                        board.boardId,
//                        board.content,
//                        board.title,
//                        board.cDate,
//                        board.uDate)).
//                from(board).
//                fetch();
//    }
}
