package com.toy.dto.board;

import lombok.Getter;

@Getter
public class BoardRequestDTO {
    private String userId;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "BoardRequestDTO{" +
                "userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
