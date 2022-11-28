package com.box.boilerplate.board.controller;


import com.box.boilerplate.board.service.BoardService;
import com.box.boilerplate.board.vo.BoardVO;
import com.box.boilerplate.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


    @GetMapping(value="")
    public String boardMain(){

        return "board/boardMain";
    }

    @GetMapping(value="/list")
    public ResultVO<?> boardList(){

        return boardService.selectListBoard();
    }



    @PostMapping(value="/insert")
    public ResultVO<?> insertBoard(@RequestBody BoardVO params){

        return boardService.insertBoard(params);
    }




}
