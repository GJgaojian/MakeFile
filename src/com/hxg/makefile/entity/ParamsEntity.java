package com.hxg.makefile.entity;

import java.io.Serializable;


public class ParamsEntity implements Serializable {

	private String params;
	private String url;
	private String method;

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public ParamsEntity(String params) {
		super();
		this.params = params;
	}

	public ParamsEntity(String params, String url, String method) {
		super();
		this.params = params;
		this.url = url;
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "ParamsEntity [params=" + params + ", url=" + url + ", method="
				+ method + "]";
	}
}
