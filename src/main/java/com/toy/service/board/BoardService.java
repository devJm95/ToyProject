package com.toy.service.board;

import com.toy.dto.board.BoardDTO;
import com.toy.dto.board.BoardRequestDTO;
import com.toy.entity.board.Board;
import com.toy.repository.board.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Board insertBoard(BoardRequestDTO boardRequestDto) {
        Board board = Board.toEntity(boardRequestDto);
        return boardRepository.save(board);
    }

    public Board boardOne(Long id) {
        return boardRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Can not found board id : " + id));
    }

    public Board updateBoard(Long id, BoardRequestDTO boardRequestDto) {
        Board chkId = boardRepository.findById(id).orElse(null);
        if(chkId != null){  // id값이 존재 하는 경우
            boardRequestDto.setBoardId(id);
            Board board = Board.toEntity(boardRequestDto);
            return boardRepository.save(board);
        } else {
            throw new EntityNotFoundException("Can not found board id : " + id);
        }
    }

    public void deleteBoardOne(Long id) {
        Board chkId = boardRepository.findById(id).orElse(null);
        if(chkId != null){  // id값이 존재 하는 경우
            boardRepository.delete(chkId);
        } else {
            throw new EntityNotFoundException("Can not found board id : " + id);
        }
    }
}
