package com.chiacon.methodBody;

import com.chiacon.constants.FrameworkConstant;
import com.chiacon.jsonReader.JsonReader;

public class MethodsBody {

	public static String getPostBody() {
		return JsonReader.readJsonFileAsString(FrameworkConstant.getPostBodyFilePath());
	}

	public static String getPatchBody() {
		return JsonReader.readJsonFileAsString(FrameworkConstant.getPatchBodyFilePath());
	}
}
