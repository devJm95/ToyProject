package com.toy.entity.board;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue
    private Long boardId;
    private String userId;
    private String title;
    private String content;
    private LocalDateTime cDate;
    private LocalDateTime uDate;
}
