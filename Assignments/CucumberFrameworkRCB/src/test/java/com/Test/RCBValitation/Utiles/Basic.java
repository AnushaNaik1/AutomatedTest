package com.Test.RCBValitation.Utiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.simple.parser.ParseException;

import io.restassured.path.json.JsonPath;

public class Basic {
	public static FileReader jsonString;
	public static JsonPath jpath;
	public static JsonPath teamJpath;
	public JSONArray people;
	public static FileInputStream fis;
	public static Properties config = new Properties();


	public void ReadJson() throws FileNotFoundException, IOException, ParseException {
		fis = new FileInputStream("./src/test/resources/properties/config.properties");
		config.load(fis);
		jsonString = new FileReader(config.getProperty("FilePath"));
		jpath = JsonPath.with(jsonString);

	}

	public List<String> getCountry() {
		List<String> list = new ArrayList<String>();
		list = jpath.getList("player.country");
		return list;
	}

	public List<String> getRole() {
		List<String> list = new ArrayList<String>();
		list = jpath.getList("player.role");
		return list;
	}

}
