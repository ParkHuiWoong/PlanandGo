package com.plan_and_go.plan_and_go_Prj.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List selectAllBoards() {
    	List<PlaceVO> placeList = null;
    	placeList = sqlSession.selectList("mapper.board.selectAllBoards");
        return placeList;
    }
}
