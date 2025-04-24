package com.plan_and_go.plan_and_go_Prj.planner.vo;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("activityVO")
public class ActivityVO {
	private String ACTIVITY_NAME;
	private String ACTIVITY_TIME;
	private String EXPECTED_COST;
	private Date ACTIVITY_DATE;
	private int ACTIVITY_ID;
	private int SCHEDULE_ID;
	private String PLACE_ID;
	private String ACTUAL_COST;
	private String PLACE_NAME;
	private String COMMENT;

	
	public ActivityVO() {
		
	}

	public String getACTIVITY_NAME() {
		return ACTIVITY_NAME;
	}

	public void setACTIVITY_NAME(String aCTIVITY_NAME) {
		ACTIVITY_NAME = aCTIVITY_NAME;
	}

	public String getACTIVITY_TIME() {
		return ACTIVITY_TIME;
	}

	public void setACTIVITY_TIME(String aCTIVITY_TIME) {
		ACTIVITY_TIME = aCTIVITY_TIME;
	}

	public String getEXPECTED_COST() {
		return EXPECTED_COST;
	}

	public void setEXPECTED_COST(String eXPECTED_COST) {
		EXPECTED_COST = eXPECTED_COST;
	}

	public Date getACTIVITY_DATE() {
		return ACTIVITY_DATE;
	}

	public void setACTIVITY_DATE(Date aCTIVITY_DATE) {
		ACTIVITY_DATE = aCTIVITY_DATE;
	}

	public int getACTIVITY_ID() {
		return ACTIVITY_ID;
	}

	public void setACTIVITY_ID(int aCTIVITY_ID) {
		ACTIVITY_ID = aCTIVITY_ID;
	}

	public int getSCHEDULE_ID() {
		return SCHEDULE_ID;
	}

	public void setSCHEDULE_ID(int sCHEDULE_ID) {
		SCHEDULE_ID = sCHEDULE_ID;
	}

	public String getPLACE_ID() {
		return PLACE_ID;
	}

	public void setPLACE_ID(String pLACE_ID) {
		PLACE_ID = pLACE_ID;
	}

	public String getACTUAL_COST() {
		return ACTUAL_COST;
	}

	public void setACTUAL_COST(String aCTUAL_COST) {
		ACTUAL_COST = aCTUAL_COST;
	}
	
	public String getPLACE_NAME() {
		return PLACE_NAME;
	}

	public void setPLACE_NAME(String pLACE_NAME) {
		PLACE_NAME = pLACE_NAME;
	}

	public String getCOMMENT() {
		return COMMENT;
	}

	public void setCOMMENT(String cOMMENT) {
		COMMENT = cOMMENT;
	}
	
	
}
