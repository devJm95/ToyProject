package com.toy.repository.board.orm;

import com.toy.repository.board.BoardQueryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BoardQueryRepositoryImpl implements BoardQueryRepository {

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
