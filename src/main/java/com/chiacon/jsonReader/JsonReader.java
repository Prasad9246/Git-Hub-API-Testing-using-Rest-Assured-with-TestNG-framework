package com.chiacon.jsonReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {
	
	 public static String readJsonFileAsString(String filePath) {
	        try {
	            String content = new String(Files.readAllBytes(Paths.get(filePath)));
	            return content;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

}
