package com.plan_and_go.plan_and_go_Prj.planner.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.plan_and_go.plan_and_go_Prj.group.vo.GroupTBVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ScheduleVO;

public interface PlannerService {
//	 public List listMembers() throws DataAccessException;
	 public void addActivity(ActivityVO activity) throws DataAccessException;
	 public int addSchedule(ScheduleVO schedule) throws DataAccessException;
//	 public int removeMember(String id) throws DataAccessException;
	 public List<ActivityVO> getActivity(int schedule_Id);
	 public void removeActivity(int schedule_id);
	 public List getActivityUpdate(int schedule_Id);
	 public void updateActivity(ActivityVO activity) throws DataAccessException;
}
	