package com.automation.test.palnet.demo;

public class TestExcelMethods {
	public static void main(String[] args) throws Exception {
		ExcelOperations excel = new ExcelOperations();
		String currentProjPath = System.getProperty("user.dir");
		System.out.println(currentProjPath);
		System.out.println("----------------------------Excel Data------------------------");
		excel.readDataFromExcel(System.getProperty("user.dir")+"//src//main//resources//Test.xlsx");
		
//		excel.writeDataToExcel(System.getProperty("user.dir")+"//src//main//resources//Test.xlsx", "July_2024_New", "New Test Data");
		System.out.println("----------------------------JSON Data------------------------");
		JsonOperations json = new JsonOperations();
		json.readDataFromJson(currentProjPath+"//src//main//resources//Test.json");
		
		System.out.println("----------------------------JSON Data Using ObjectMapper------------------------");
		json.readDataFromJsonUsingObjectMapper(currentProjPath+"//src//main//resources//Test.json");
		
		System.out.println("----------------------------XML Data------------------------");
		XmlOperations xml = new XmlOperations();
		xml.readDataFromXML(currentProjPath+"//src//main//resources//Test.xml");
	}
}
