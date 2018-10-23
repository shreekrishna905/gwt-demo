package com.leapfrog.acustream.client.mvc.views;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.leapfrog.acustream.client.grids.ItemGrid;
import com.leapfrog.acustream.client.mvc.controllers.StudentController;
import com.leapfrog.acustream.client.mvc.events.AppEvents;
import com.leapfrog.acustream.client.windows.RebuttalWindow;
import com.leapfrog.acustream.client.windows.StudentWindow;
import com.leapfrog.acustream.shared.Student;

public class StudentView extends View {

	private ItemGrid itemGrid;
	
	public StudentView(StudentController controller) {
		super(controller);
		itemGrid = new ItemGrid();
	}

	private void onShowList() {
		System.out.println("Adding Grid item in app main");
		ContentPanel main =  (ContentPanel) Registry.get(AppView.MAIN_PANEL);
		main.add(itemGrid);
		appendButton(main);
		main.layout();
	}
	
	private void appendButton(ContentPanel main) {
		final LayoutContainer botPanel = new LayoutContainer(new FlowLayout());
		ButtonBar buttons = new ButtonBar();
		Button buttonNew = new Button("NEW");
		Button buttonRebuttal = new Button("REBUTTAL");
		
		buttonNew.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				createNewStudentWindow();
			}
		});
		
		buttonRebuttal.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				createRebuttalWindow();
			}
		});
		
		buttons.add(buttonNew);
		buttons.add(buttonRebuttal);
		botPanel.add(buttons);
		main.add(botPanel, new RowData(1, 1, new Margins(5, 0, 0, 0)));
	}
	
	private void createNewStudentWindow(){
		final Window newStudentWindow = new StudentWindow(new Student());
		newStudentWindow.show();
	}
	
	private void createRebuttalWindow(){
		final Window  rebuttalWindow = new RebuttalWindow();
		rebuttalWindow.show();
	}


	@Override
	protected void handleEvent(AppEvent event) {
		EventType eventType = event.getType();
		if (eventType.equals(AppEvents.SHOW_LIST)) {
			onShowList();
		} 
	}

}
