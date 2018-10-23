package com.leapfrog.acustream.client;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.leapfrog.acustream.client.mvc.controllers.AppController;
import com.leapfrog.acustream.client.mvc.controllers.StudentController;
import com.leapfrog.acustream.client.mvc.events.AppEvents;
import com.leapfrog.acustream.client.services.StudentService;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Acustream implements EntryPoint {
	
	public void onModuleLoad() {
		Registry.register(AcustreamConstants.STUDENT_SERVICE, GWT.create(StudentService.class));
		Dispatcher dispatcher = Dispatcher.get();
		dispatcher.addController(new AppController());
		dispatcher.addController(new StudentController());
		dispatcher.dispatch(AppEvents.Init);
	}
	
}
