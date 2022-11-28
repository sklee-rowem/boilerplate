package com.box.boilerplate.board.service;

import com.box.boilerplate.board.model.BoardEntity;
import com.box.boilerplate.board.repository.BoardRepository;
import com.box.boilerplate.board.vo.BoardVO;
import com.box.boilerplate.common.ErrorCode;
import com.box.boilerplate.common.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{

    private BoardRepository boardRepository;

    @Override
    public ResultVO<?> insertBoard(BoardVO params) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setContent(params.getContent());
        boardEntity.setTitle(params.getTitle());
        boardEntity.setUserId(params.getUserId());
        boardEntity.setUsedYn("Y");
        BoardEntity save = boardRepository.save(boardEntity);

        ResultVO<BoardEntity> ResultVO = new ResultVO<>();
        ResultVO.setErrorCode(ErrorCode.SUCCESS.getCode());
        ResultVO.setErrorMessage(ErrorCode.SUCCESS.getMessage());

        return ResultVO;
    }

    @Override
    public ResultVO<?> selectListBoard() {

        List<BoardEntity> boardList = boardRepository.findByUsedYn("Y");
        ResultVO<List<BoardEntity>> ResultVO = new ResultVO<>();
        ResultVO.setErrorCode(ErrorCode.SUCCESS.getCode());
        ResultVO.setErrorMessage(ErrorCode.SUCCESS.getMessage());
        ResultVO.setResult(boardList);
        return ResultVO;
    }

    @Override
    public ResultVO<?> selectBoard(Long board_no) {

        Optional<BoardEntity> byId = boardRepository.findById(board_no);
        BoardEntity boardEntity = byId.get();
        ResultVO<BoardEntity> ResultVO = new ResultVO<>();
        ResultVO.setErrorCode(ErrorCode.SUCCESS.getCode());
        ResultVO.setErrorMessage(ErrorCode.SUCCESS.getMessage());
        ResultVO.setResult(boardEntity);
        return ResultVO;
    }

    @Override
    public ResultVO<?> updateBoard(BoardEntity board) {
        return null;
    }

    @Override
    public ResultVO<?> deleteBoard(Long board_no) {
        return null;
    }
}
