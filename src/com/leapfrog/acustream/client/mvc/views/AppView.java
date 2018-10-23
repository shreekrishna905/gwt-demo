package com.leapfrog.acustream.client.mvc.views;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.leapfrog.acustream.client.grids.ItemGrid;
import com.leapfrog.acustream.client.mvc.controllers.AppController;
import com.leapfrog.acustream.client.mvc.events.AppEvents;

public class AppView extends View {
	
	public static final String MAIN_PANEL = "main_panel";

	private final ContentPanel mainPanel = new ContentPanel();

	private final Viewport viewport = new Viewport();

	public AppView(AppController appController) {
		super(appController);
	}

	private void onInit(AppEvent event) {
		final BorderLayout borderLayout = new BorderLayout();
		viewport.setLayout(borderLayout);

		BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, 20);
		northData.setCollapsible(false);
		northData.setSplit(false);
		viewport.add(getHeader(), northData);

		BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
		centerData.setCollapsible(false);
		centerData.setMargins(new Margins(15, 0, 0, 0));
		RowLayout rowLayout = new RowLayout(Orientation.VERTICAL);
		mainPanel.setHeaderVisible(false);
		mainPanel.setLayout(rowLayout);
		Registry.register(MAIN_PANEL, mainPanel);
		viewport.add(mainPanel, centerData);

		BorderLayoutData southData = new BorderLayoutData(LayoutRegion.SOUTH, 20);
		southData.setMargins(new Margins(0, 0, 5, 0));
		southData.setCollapsible(false);
		southData.setSplit(false);
		viewport.add(getFooter(), southData);
		RootPanel.get().add(viewport);
	}

	@Override
	protected void handleEvent(AppEvent event) {
		EventType eventType = event.getType();
		if (eventType.equals(AppEvents.Init)) {
			onInit(event);
			Dispatcher.forwardEvent(AppEvents.SHOW_LIST);
		} 
	}
	


	public LayoutContainer getHeader() {
		LayoutContainer header = new LayoutContainer();
		header.setLayout(new ColumnLayout());

		// Header Left Container
		LayoutContainer left = new LayoutContainer();
		left.setStyleAttribute("paddingRight", "10px");
		HTML headerLeftInfo = new HTML();
		headerLeftInfo.setHTML("<h1 class=\"header\">Acustream Header</h1>");
		left.add(headerLeftInfo);

		// Header Middle Container
		LayoutContainer middle = new LayoutContainer();
		middle.setStyleAttribute("paddingLeft", "100px");
		final SimpleComboBox<String> roles = new SimpleComboBox<String>();
		roles.add("CLIENT");
		roles.add("ADMIN");

		roles.addListener(Events.SelectionChange, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent event) {
				String department = roles.getSimpleValue().toString();
				Grid<BaseModel> grid = Registry.get(ItemGrid.ITEM_GRID);
				if (department.equalsIgnoreCase("CLIENT")) {
					grid.getColumnModel().setHidden(3, Boolean.TRUE);
					grid.getColumnModel().setHidden(4, Boolean.TRUE);
				} else if (department.equalsIgnoreCase("ADMIN")) {
					grid.getColumnModel().setHidden(3, Boolean.FALSE);
					grid.getColumnModel().setHidden(4, Boolean.FALSE);
				}
			}
		});

		middle.add(roles);

		// Header Right Container
		LayoutContainer right = new LayoutContainer();
		right.setStyleAttribute("paddingLeft", "400px");
		HTML headerRightInfo = new HTML();
		headerRightInfo.setHTML("<a href=\"#\">Click Here</a>");
		right.add(headerRightInfo);

		header.add(left, new ColumnData(.3));
		header.add(middle, new ColumnData(.3));
		header.add(right, new ColumnData());

		return header;
	}
	
	public VerticalPanel getFooter() {
		VerticalPanel footerPanel = new VerticalPanel();
		Label label = new Label("Copyright © Acustream.");
		footerPanel.add(label);
		return footerPanel;
	}

}
