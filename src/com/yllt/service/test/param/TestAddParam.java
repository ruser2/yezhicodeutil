package com.yllt.service.test.param;

import com.yllt.com.framework.json.annotation.Field;

public class TestAddParam {

	@Field(nullable=false,description="名称")
	private String name;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
