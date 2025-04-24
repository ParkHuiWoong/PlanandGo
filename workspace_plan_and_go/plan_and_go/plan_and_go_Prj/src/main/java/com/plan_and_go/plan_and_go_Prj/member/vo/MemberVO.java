package com.plan_and_go.plan_and_go_Prj.member.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private String MEMBER_ID;
	private String MEMBER_NAME;
	private String PASSWORD;
	private String EMAIL;
	private String PHONE_NUMBER;
	private Date JOIN_DATE;
	private Date UPDATED_DATE;
	private Date LEAVE_DATE;
	private String NICKNAME;
	private String tempPassword;

	public String getMEMBER_ID() {
		return MEMBER_ID;
	}

	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}

	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}

	public void setMEMBER_NAME(String mEMBER_NAME) {
		MEMBER_NAME = mEMBER_NAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}

	public Date getJOIN_DATE() {
		return JOIN_DATE;
	}

	public void setJOIN_DATE(Date jOIN_DATE) {
		JOIN_DATE = jOIN_DATE;
	}

	public Date getUPDATED_DATE() {
		return UPDATED_DATE;
	}

	public void setUPDATED_DATE(Date uPDATED_DATE) {
		UPDATED_DATE = uPDATED_DATE;
	}

	public Date getLEAVE_DATE() {
		return LEAVE_DATE;
	}

	public void setLEAVE_DATE(Date lEAVE_DATE) {
		LEAVE_DATE = lEAVE_DATE;
	}

	public String getNICKNAME() {
		return NICKNAME;
	}

	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

}