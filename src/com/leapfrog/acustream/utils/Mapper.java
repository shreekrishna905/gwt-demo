package com.leapfrog.acustream.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {

	private static ObjectMapper instance = null;
	
	private Mapper(){}
	
	public static ObjectMapper getInstance(){
		if(instance==null){
			instance = new ObjectMapper();
		}
		return instance;
	}
	
}
