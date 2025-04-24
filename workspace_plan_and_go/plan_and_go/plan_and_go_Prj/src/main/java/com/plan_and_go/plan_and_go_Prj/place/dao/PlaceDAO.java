package com.plan_and_go.plan_and_go_Prj.place.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface PlaceDAO {
	public List selectRegionList() throws DataAccessException;
	public List selectPlaceList(String region) throws DataAccessException;
}
