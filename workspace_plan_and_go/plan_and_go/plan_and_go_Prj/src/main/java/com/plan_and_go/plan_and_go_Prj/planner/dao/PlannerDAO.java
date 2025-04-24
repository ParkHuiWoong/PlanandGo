package com.plan_and_go.plan_and_go_Prj.planner.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.plan_and_go.plan_and_go_Prj.group.vo.GroupTBVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ScheduleVO;

public interface PlannerDAO {
//	 public List selectAllMemberList() throws DataAccessException;
	public void insertActivity(ActivityVO activityVO) throws DataAccessException;

	public int insertSchedule(ScheduleVO scheduleVO) throws DataAccessException;

	public int insertGroup(GroupTBVO groupTB) throws DataAccessException;
//	 public int deleteMember(String id) throws DataAccessException;

	public List<ActivityVO> selectActivity(int schedule_Id);
	public void delActivity(int schedule_Id);
	public List selectActivityUpdate(int schedule_Id);
	public void updateActivity(ActivityVO activityVO) throws DataAccessException;
}
