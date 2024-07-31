package com.automation.test.palnet.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonOperations {

	public void readDataFromJson(String jsonFilePath) throws Exception {
	
		JSONParser jParse = new JSONParser();
		JSONObject  jObject= (JSONObject)jParse.parse(new FileReader(jsonFilePath));
		
		System.out.println(jObject.toString());
		System.out.println(jObject.get("userName"));
		System.out.println(jObject.get("password")); 
	}
	
	public void readDataFromJsonUsingObjectMapper(String jsonFilePath) throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		TestJsonModelPojo testPojo = objMapper.readValue(Paths.get(jsonFilePath).toFile(), TestJsonModelPojo.class);		
		System.out.println(testPojo.getUserName());
		System.out.println(testPojo.getPassword()); 
		
	}
}
