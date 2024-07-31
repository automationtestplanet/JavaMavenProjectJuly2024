package com.automation.test.palnet.demo;

import java.io.IOException;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlOperations {
	
	public void readDataFromXML(String filePath) throws Exception {
		ObjectMapper objMapper =  new XmlMapper();
		TestXMLModelPojo xmlPojo = objMapper.readValue(Paths.get(filePath).toFile(), TestXMLModelPojo.class);
		System.out.println(xmlPojo.getUserName());
		System.out.println(xmlPojo.getPassword());		
	}

}
