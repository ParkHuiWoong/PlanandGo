package com.plan_and_go.plan_and_go_Prj.region.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;

public interface RegionService {
	List getRegion() throws DataAccessException;
	
	List getPlaces(String region) throws DataAccessException;;
}
