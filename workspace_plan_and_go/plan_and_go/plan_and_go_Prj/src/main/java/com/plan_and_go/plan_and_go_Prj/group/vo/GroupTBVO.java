package com.plan_and_go.plan_and_go_Prj.group.vo;

import org.springframework.stereotype.Component;

@Component("groupTBVO")
public class GroupTBVO {
	private String group_id;
	private String group_name;

	public GroupTBVO() {
		
	}
	
	public GroupTBVO(String group_id, String group_name) {
		this.group_id = group_id;
		this.group_name = group_name;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

}
