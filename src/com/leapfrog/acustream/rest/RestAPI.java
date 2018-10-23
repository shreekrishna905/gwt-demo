package com.leapfrog.acustream.rest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class RestAPI {

	public static String get(String url) throws Exception {
		Response response = null;
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(url);
		response = target.request().accept("application/json").get();
		return response.readEntity(String.class);
	}
	
	public static String post(String url, Object data) throws Exception {
		Response response = null;
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(url);
		response = target.request().post(Entity.entity(data, "application/json"));
		return response.readEntity(String.class);
	}
	
	

}
