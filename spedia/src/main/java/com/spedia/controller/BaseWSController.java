package com.spedia.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class BaseWSController {
	private Gson gson = null;

	public BaseWSController() {
		super();
		if (gson == null) {
			gson = new GsonBuilder().serializeNulls().create();
		}
	}

	public synchronized String convertIntoJson(Object O) {
		return gson.toJson(O);
	}

	@SuppressWarnings("rawtypes")
	public synchronized <T> T convertJsonIntoObject(String json, TypeToken typeToken) {
		T t = null;
		try {
			t = gson.fromJson(json, typeToken.getType());
		} catch (Exception e) {
			// TODO: USE LOGGER INSTEAND OF SYSOUT
			//System.out.println("Error : could not convert json into Object for the class " + t.getClass().getName() + " :: " + e);
			e.printStackTrace();
		}
		return t;
	}

}
