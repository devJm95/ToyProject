package com.toy.service.board;

import com.toy.dto.board.BoardDTO;
import com.toy.dto.board.BoardRequestDTO;
import com.toy.dto.board.BoardResponseDto;
import com.toy.entity.board.Board;
import com.toy.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    public List<BoardDTO> getBaordList() {
        // TODO : 여기서 entity를 DTO화해서 리턴하게 수정하기
        List<Board> result = boardRepository.findAll();
        return  result.stream().
                map(board -> modelMapper.map(board, BoardDTO.class)).
                collect(Collectors.toList());
    }

    public Board insertBoard(BoardDTO boardDto) {
        Board board = modelMapper.map(boardDto, Board.class);
        return boardRepository.save(board);
    }
}
