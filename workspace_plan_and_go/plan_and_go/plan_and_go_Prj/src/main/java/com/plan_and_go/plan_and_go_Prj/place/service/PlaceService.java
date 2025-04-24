package com.plan_and_go.plan_and_go_Prj.place.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;

public interface PlaceService {
	List getRegion() throws DataAccessException;
	
	List getPlaces(String region) throws DataAccessException;;
}
