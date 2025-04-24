package com.plan_and_go.plan_and_go_Prj.group.vo;

import org.springframework.stereotype.Component;

@Component("groupJoinVO")
public class GroupJoinVO {
	private int group_id;
	private String MEMBER_ID;

	public GroupJoinVO() {
		
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getMember_id() {
		return MEMBER_ID;
	}

	public void setMember_id(String MEMBER_ID) {
		this.MEMBER_ID = MEMBER_ID;
	}

}
