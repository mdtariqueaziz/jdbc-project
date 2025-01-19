package com.tarique.response;

import lombok.Data;

@Data
public class JsonResponse {

	public static final String SUCCESS = "success";
	public static final String FAILED = "failed";
	public static final String STATUS_CODE_201 = "201";
	public static final String STATUS_CODE_200 = "200";

	private Object result;
	private String status;
	private String message;
	private String code;

	public JsonResponse(Object result, String status, String message, String code) {
		super();
		this.result = result;
		this.status = status;
		this.message = message;
		this.code = code;
	}

	public JsonResponse(Object result, String status, String code) {
		super();
		this.result = result;
		this.status = status;
		this.code = code;
	}

}
