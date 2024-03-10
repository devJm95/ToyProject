package com.toy.dto.board;

import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class BoardResponseDto {
    private Long boardId;
    private String userId;
    private String title;
    private String content;
    private LocalDateTime cDate;
    private LocalDateTime uDate;
}
