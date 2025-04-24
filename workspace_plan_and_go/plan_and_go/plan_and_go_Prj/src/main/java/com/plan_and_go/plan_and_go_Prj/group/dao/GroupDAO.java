package com.plan_and_go.plan_and_go_Prj.group.dao;

import org.springframework.dao.DataAccessException;

import com.plan_and_go.plan_and_go_Prj.group.vo.GroupTBVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ScheduleVO;

public interface GroupDAO {


	public void insertGroup(String group_name) throws DataAccessException;
	public int selectGroup(String group_name) throws DataAccessException;
	public void insertGroupJoin(int group_id, String MEMBER_ID) throws DataAccessException;


}
