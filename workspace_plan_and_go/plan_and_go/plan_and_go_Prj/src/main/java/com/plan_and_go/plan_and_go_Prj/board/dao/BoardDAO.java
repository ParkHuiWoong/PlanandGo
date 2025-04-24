package com.plan_and_go.plan_and_go_Prj.board.dao;

import java.util.List;

import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;

public interface BoardDAO {
    public List<PlaceVO> selectAllBoards(); // 전체 게시글 조회
}
