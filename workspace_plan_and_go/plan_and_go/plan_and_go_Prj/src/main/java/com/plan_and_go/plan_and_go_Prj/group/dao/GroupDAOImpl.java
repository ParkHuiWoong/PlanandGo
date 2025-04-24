package com.plan_and_go.plan_and_go_Prj.group.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.plan_and_go.plan_and_go_Prj.group.vo.GroupJoinVO;


@Repository("groupDAO")
public class GroupDAOImpl implements GroupDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertGroup(String group_name) throws DataAccessException {
		sqlSession.insert("mapper.group.insertGroup", group_name);

	}

	@Override
	public int selectGroup(String group_name) throws DataAccessException {
		int result = sqlSession.selectOne("mapper.group.selectGroup", group_name);
		return result;
	}

	@Override
	public void insertGroupJoin(int group_id, String MEMBER_ID) throws DataAccessException {
		GroupJoinVO groupJoinVO = new GroupJoinVO();
		groupJoinVO.setGroup_id(group_id);
		groupJoinVO.setMember_id(MEMBER_ID);
		
		sqlSession.insert("mapper.group.insertGroupJoin", groupJoinVO);
		
	}

}
