package com.leapfrog.acustream.client.mvc.controllers;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.leapfrog.acustream.client.mvc.events.AppEvents;
import com.leapfrog.acustream.client.mvc.views.AppView;

public class AppController extends Controller {

	private View appView;
	
	public AppController() {
		registerEventTypes(AppEvents.Init);
	}
	
	@Override
	public void handleEvent(AppEvent event) {
		forwardToView(appView, event);
	}

	@Override
	public void initialize() {
		super.initialize();
		appView = new AppView(this);
	}

}
