package com.toy.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequestDTO {
        private String userId;
        private String title;
        private String content;
        private LocalDateTime cDate;
        private LocalDateTime uDate;

}
