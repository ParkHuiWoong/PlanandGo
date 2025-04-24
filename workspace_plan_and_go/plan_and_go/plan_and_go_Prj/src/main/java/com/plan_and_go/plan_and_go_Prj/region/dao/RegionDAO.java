package com.plan_and_go.plan_and_go_Prj.region.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface RegionDAO {
	public List selectRegionList() throws DataAccessException;
	public List selectPlaceList(String region) throws DataAccessException;
}
