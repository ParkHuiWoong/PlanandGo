package com.plan_and_go.plan_and_go_Prj.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plan_and_go.plan_and_go_Prj.board.dao.BoardDAO;
import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List listBoards() {
    	List placeList = null;
    	placeList = boardDAO.selectAllBoards();
        return placeList;
    }
}
