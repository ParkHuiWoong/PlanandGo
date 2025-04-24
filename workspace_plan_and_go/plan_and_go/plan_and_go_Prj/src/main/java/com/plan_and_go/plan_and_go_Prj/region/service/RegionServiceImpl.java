package com.plan_and_go.plan_and_go_Prj.region.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.plan_and_go.plan_and_go_Prj.place.dao.PlaceDAO;


@Service("regionService")
@Transactional(propagation = Propagation.REQUIRED)
public class RegionServiceImpl implements RegionService{
	@Autowired
	private PlaceDAO placeDAO;
		
	@Override
    public List getRegion() throws DataAccessException {
		List regionList = null;
		regionList = placeDAO.selectRegionList();
        return regionList;
    }

	public List getPlaces(String region) throws DataAccessException {
		List PlaceList = null;
		PlaceList = placeDAO.selectPlaceList(region);
        return PlaceList;
    }

}
