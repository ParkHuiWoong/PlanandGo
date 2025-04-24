package com.plan_and_go.plan_and_go_Prj.planner.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.plan_and_go.plan_and_go_Prj.group.vo.GroupJoinVO;
import com.plan_and_go.plan_and_go_Prj.group.vo.GroupTBVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ScheduleVO;


@Repository("plannerDAO")
public class PlannerDAOImpl implements PlannerDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertActivity(ActivityVO activityVO) throws DataAccessException {
		
		System.out.println("activityVO.getACTIVITY_DATE() : "+ activityVO.getACTIVITY_DATE());
		sqlSession.insert("mapper.planner.insertActivity", activityVO);
		
	}
	
	@Override
	public int insertSchedule(ScheduleVO scheduleVO) throws DataAccessException {
		System.out.println("------------------------------------dao");
		sqlSession.insert("mapper.planner.insertSchedule", scheduleVO);
		int schedule_id = sqlSession.selectOne("mapper.planner.selectScheduleID");
		System.out.println("ID : : " + schedule_id);
		return schedule_id;
	}
	
	@Override
	public int insertGroup(GroupTBVO groupTB) throws DataAccessException {
		int result = sqlSession.insert("mapper.planner.insertGroup", groupTB);
		return result;
	}
	
	@Override
	public List<ActivityVO> selectActivity(int schedule_Id) throws DataAccessException {
		
		return sqlSession.selectList("mapper.planner.selectActivity", schedule_Id);
	}
	
	@Override
	public void delActivity(int ACTIVITY_ID) throws DataAccessException {
		sqlSession.delete("mapper.planner.deleteActivity", ACTIVITY_ID);
	}
	
	@Override
	public List selectActivityUpdate(int schedule_id) throws DataAccessException {
		
		return sqlSession.selectList("mapper.planner.selectActivityUpdate", schedule_id);
	}
	
	@Override
	public void updateActivity(ActivityVO activityVO) throws DataAccessException {
		sqlSession.update("mapper.planner.updateActivity", activityVO);
	}
}
