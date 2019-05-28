package com.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;


/*
 * loading a TestEnvironment from a json file
 */

public class TestEnvironmentLoader {
	
	
	public static TestEnvironmentLoader INSTANCE = new TestEnvironmentLoader();
	

	private TestEnvironmentLoader() {
		
	}
	
	public TestEnvironment loadConfiguration(String env) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("settings.json"));
		TestEnvironment environment = new Gson().fromJson(br, TestEnvironment.class);
		return environment;
	}
}
