package com.sesame.http;

import java.util.Map;

public class ResponseObj<T> {
	public static String FAILD = "failed";
	public static String SUCCESS = "success";
	public static String ERROR = "error";

	public String code;
	private String msg;
	private Map data;
	private T obj;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map getData() {
		return data;
	}

	public void setData(Map data) {
		this.data = data;
	}

}
