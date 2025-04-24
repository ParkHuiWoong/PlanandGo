package com.plan_and_go.plan_and_go_Prj.group.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.plan_and_go.plan_and_go_Prj.group.dao.GroupDAO;
import com.plan_and_go.plan_and_go_Prj.group.vo.GroupTBVO;



@Service("groupService")
@Transactional(propagation = Propagation.REQUIRED)
public class GroupServiceImpl implements GroupService {
	@Autowired
	private GroupDAO groupDAO;
	
	@Override
	public int addGroup(String group_name, String MEMBER_ID) throws DataAccessException {
		
		groupDAO.insertGroup(group_name);
		System.out.println("group name : "+group_name);
		int result2 = groupDAO.selectGroup(group_name);
		
		groupDAO.insertGroupJoin(result2, MEMBER_ID);
		
		return result2;
	}
	
}
