package com.toy.contoller;

import com.toy.config.JwtTokenProvider;
import com.toy.dto.board.BoardRequestDTO;
import com.toy.entity.board.Board;
import com.toy.service.board.BoardService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @Test
    public void testInsertBoard() throws Exception {
        BoardRequestDTO requestDTO = new BoardRequestDTO();
        requestDTO.setTitle("Test Title");
        requestDTO.setContent("Test Content");

        Board board = Board.toEntity(requestDTO);

        Mockito.when(boardService.insertBoard(Mockito.any(BoardRequestDTO.class))).thenReturn(board);

        mockMvc.perform(MockMvcRequestBuilders.post("/board")
                .header("Authorization", "Bearer $jwtToken")
                .contentType("application/json")
                .content("{\"title\":\"Test Title\",\"content\":\"Test Content\"}"))
                .andDo(print());
    }
}


