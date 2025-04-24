package com.plan_and_go.plan_and_go_Prj.mypage.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("myPageVO")
public class MyPageVO {
    private int SCHEDULE_ID;
    private String SCHEDULE_NAME;
    private Date START_DATE;
    private Date END_DATE;
    private Date CREATED_DATE;
    private Date UPDATED_DATE;
    private int GROUP_ID;
    private String GROUP_NAME;
    private String NICKNAME;
    
    public MyPageVO(){
  	  
   	 
    }
    
  public int getSCHEDULE_ID() {
		return SCHEDULE_ID;
	}

	public void setSCHEDULE_ID(int sCHEDULE_ID) {
		SCHEDULE_ID = sCHEDULE_ID;
	}

	public String getSCHEDULE_NAME() {
		return SCHEDULE_NAME;
	}

	public void setSCHEDULE_NAME(String sCHEDULE_NAME) {
		SCHEDULE_NAME = sCHEDULE_NAME;
	}

	public Date getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(Date sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public Date getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(Date eND_DATE) {
		END_DATE = eND_DATE;
	}

	public Date getCREATED_DATE() {
		return CREATED_DATE;
	}

	public void setCREATED_DATE(Date cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}

	public Date getUPDATED_DATE() {
		return UPDATED_DATE;
	}

	public void setUPDATED_DATE(Date uPDATED_DATE) {
		UPDATED_DATE = uPDATED_DATE;
	}

	public int getGROUP_ID() {
		return GROUP_ID;
	}

	public void setGROUP_ID(int gROUP_ID) {
		GROUP_ID = gROUP_ID;
	}

	public String getGROUP_NAME() {
		return GROUP_NAME;
	}

	public void setGROUP_NAME(String gROUP_NAME) {
		GROUP_NAME = gROUP_NAME;
	}

	public String getNICKNAME() {
		return NICKNAME;
	}

	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}
	
}


   