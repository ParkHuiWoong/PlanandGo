package com.plan_and_go.plan_and_go_Prj.place.vo;

import org.springframework.stereotype.Component;

@Component("placeVO")
public class PlaceVO {
	private String id;
	private String name;
	private String category;
	private String info;
	private int region_id;
	private String image;
	private String SCHEDULE_ID;
	private String REGION_NAME;
	private String MEMBER_ID;
	
	
	public PlaceVO() {

	}

	public PlaceVO(String MEMBER_ID, String id, String name, String category, String info, int region_id, String image, String SCHEDULE_ID, String REGION_NAME) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.info = info;
		this.region_id = region_id;
		this.image = image;
		this.REGION_NAME = REGION_NAME;
		this.SCHEDULE_ID = SCHEDULE_ID;
		this.MEMBER_ID = MEMBER_ID;
	}

	
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}

	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public String getSCHEDULE_ID() {
		return SCHEDULE_ID;
	}

	public void setSCHEDULE_ID(String sCHEDULE_ID) {
		SCHEDULE_ID = sCHEDULE_ID;
	}

	public String getREGION_NAME() {
		return REGION_NAME;
	}

	public void setREGION_NAME(String rEGION_NAME) {
		REGION_NAME = rEGION_NAME;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
