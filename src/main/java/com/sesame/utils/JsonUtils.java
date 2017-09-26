package com.sesame.utils;

import com.sesame.http.ResponseObj;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {
	private static JsonUtils jsonUtils;

	public static JsonUtils getInstance() {
		if (jsonUtils == null)
			jsonUtils = new JsonUtils();
		return jsonUtils;
	}


	public static String toJson(ResponseObj responseObj) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("code", responseObj.getCode());
			jsonObject.put("msg", responseObj.getMsg());
			if (responseObj.getData() != null)
				jsonObject.put("data", new JSONObject(responseObj.getData()));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
//		return "{\"aa\":\"小明\"}";
	}
	public static JSONObject toJsonObj(ResponseObj responseObj) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("code", responseObj.getCode());
			jsonObject.put("msg", responseObj.getMsg());
			if (responseObj.getData() != null)
				jsonObject.put("data", new JSONObject(responseObj.getData()));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
//		return "{\"aa\":\"小明\"}";
	}

}
