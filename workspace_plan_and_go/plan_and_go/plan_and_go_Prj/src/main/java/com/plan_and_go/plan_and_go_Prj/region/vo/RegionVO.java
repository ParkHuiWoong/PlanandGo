package com.plan_and_go.plan_and_go_Prj.region.vo;

import org.springframework.stereotype.Component;

@Component("regionVO")
public class RegionVO {
	private int id;
	private String name;
	private String info;
	private String image;

	public RegionVO() {

	}

	public RegionVO(int id, String name, String info, String image) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
