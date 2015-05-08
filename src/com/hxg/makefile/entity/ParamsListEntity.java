package com.hxg.makefile.entity;

import java.io.Serializable;
import java.util.List;

public class ParamsListEntity implements Serializable {

	private List<ParamsEntity> list;

	public List<ParamsEntity> getList() {
		return list;
	}

	public void setList(List<ParamsEntity> list) {
		this.list = list;
	}

	public ParamsListEntity(List<ParamsEntity> list) {
		super();
		this.list = list;
	}
}