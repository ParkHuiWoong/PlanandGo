package com.plan_and_go.plan_and_go_Prj.planner.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("scheduleVO")
public class ScheduleVO {
	private int schedule_id;
	private String schedule_name;
	private String region;
	private Date start_date;
	private Date end_date;
	private int group_id;
	private String region_name;
	
	public ScheduleVO() {
		
	}
	
	public ScheduleVO(int schedule_id, String schedule_name, Date start_date, Date end_date, int group_id) {
		this.schedule_id = schedule_id;
		this.schedule_name = schedule_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.group_id = group_id;
	}
	
	
	public int getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getSchedule_name() {
		return schedule_name;
	}

	public void setSchedule_name(String schedule_name) {
		this.schedule_name = schedule_name;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	
	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	
}
