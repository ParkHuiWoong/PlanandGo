package com.plan_and_go.plan_and_go_Prj.region.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;

@Repository("regionDAO")
public class RegionDAOImpl implements RegionDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectRegionList() throws DataAccessException {
		List<PlaceVO> regionList = null;
		regionList = sqlSession.selectList("mapper.planner.selectRegionList");
		return regionList;
	}
	
	@Override
	public List selectPlaceList(String region) throws DataAccessException {
		List<PlaceVO> placeList = null;
		placeList = sqlSession.selectList("mapper.planner.selectPlaceList", region);
		return placeList;
	}
}
