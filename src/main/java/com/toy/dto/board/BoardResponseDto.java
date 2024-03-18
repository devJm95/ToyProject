package com.toy.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {
    private String title;
    private String content;
    private LocalDateTime cDate;
    private LocalDateTime uDate;
}
