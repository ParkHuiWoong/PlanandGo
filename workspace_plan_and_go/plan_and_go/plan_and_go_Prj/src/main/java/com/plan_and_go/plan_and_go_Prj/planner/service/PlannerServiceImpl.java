package com.plan_and_go.plan_and_go_Prj.planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.plan_and_go.plan_and_go_Prj.planner.dao.PlannerDAO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ScheduleVO;



@Service("plannerService")
@Transactional(propagation = Propagation.REQUIRED)
public class PlannerServiceImpl implements PlannerService {
	@Autowired
	private PlannerDAO plannerDAO;

	@Override
	public void addActivity(ActivityVO activity) throws DataAccessException {
		plannerDAO.insertActivity(activity);
	}
	
	@Override
	public int addSchedule(ScheduleVO schedule) throws DataAccessException {
		System.out.println("------------------------------------ser");
		int result = 0;
		result = plannerDAO.insertSchedule(schedule);
		return result;
	}
	
	@Override
	public List<ActivityVO> getActivity(int schedule_Id) throws DataAccessException {
		return plannerDAO.selectActivity(schedule_Id);
	}
	
	@Override
	public void removeActivity(int ACTIVITY_ID) throws DataAccessException {
		plannerDAO.delActivity(ACTIVITY_ID);
	}
	
	@Override
	public List getActivityUpdate(int schedule_Id) throws DataAccessException {
		return plannerDAO.selectActivityUpdate(schedule_Id);
	}
	
	@Override
	public void updateActivity(ActivityVO activity) throws DataAccessException {
		plannerDAO.updateActivity(activity);
	}
		
}
