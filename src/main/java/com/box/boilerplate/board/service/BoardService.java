package com.box.boilerplate.board.service;

import com.box.boilerplate.board.model.BoardEntity;
import com.box.boilerplate.board.vo.BoardVO;
import com.box.boilerplate.common.vo.ResultVO;

public interface BoardService {

    ResultVO<?> insertBoard(BoardVO params);

    ResultVO<?> selectListBoard();

    ResultVO<?> selectBoard(Long board_no);

    ResultVO<?> updateBoard(BoardEntity boardEntity);

    ResultVO<?> deleteBoard(Long board_no);

}
