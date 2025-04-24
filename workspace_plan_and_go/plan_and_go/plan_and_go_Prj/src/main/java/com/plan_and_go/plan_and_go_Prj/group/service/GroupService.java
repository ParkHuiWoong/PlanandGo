package com.plan_and_go.plan_and_go_Prj.group.service;

import org.springframework.dao.DataAccessException;

import com.plan_and_go.plan_and_go_Prj.group.vo.GroupTBVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ScheduleVO;

public interface GroupService {

	 public int addGroup(String group_name, String MEMBER_ID) throws DataAccessException;

}
