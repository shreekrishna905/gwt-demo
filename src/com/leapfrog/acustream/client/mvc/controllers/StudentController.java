package com.leapfrog.acustream.client.mvc.controllers;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.leapfrog.acustream.client.mvc.events.AppEvents;
import com.leapfrog.acustream.client.mvc.views.StudentView;

public class StudentController extends Controller {

	private StudentView studentView;
	
	public StudentController(){
		registerEventTypes(AppEvents.SHOW_LIST);
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		studentView = new StudentView(this);
	}
	
	@Override
	public void handleEvent(AppEvent event) {
		forwardToView(studentView, event);
	}

}
