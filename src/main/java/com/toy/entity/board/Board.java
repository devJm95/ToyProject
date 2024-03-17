package com.toy.entity.board;

import com.toy.dto.board.BoardRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue
    private Long boardId;
    private String userId;
    private String title;
    private String content;
    private LocalDateTime cDate;
    private LocalDateTime uDate;

    public static Board toEntity(BoardRequestDTO boardRequestDTO){
        return Board.builder()
                .userId(boardRequestDTO.getUserId())
                .title(boardRequestDTO.getTitle())
                .content(boardRequestDTO.getContent())
                .cDate(LocalDateTime.now())
                .uDate(LocalDateTime.now())
                .build();
    }
}
