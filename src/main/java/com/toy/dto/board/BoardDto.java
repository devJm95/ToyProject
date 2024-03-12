package com.toy.dto.board;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class BoardDto {

    @Id
    @GeneratedValue
    private Long boardId;
    private String userId;
    private String title;
    private String content;
    private LocalDateTime cDate;
    private LocalDateTime uDate;

    @QueryProjection
    public BoardDto(Long boardId, String title, String content, LocalDateTime cDate, LocalDateTime uDate) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.cDate = cDate;
        this.uDate = uDate;
    }

}
