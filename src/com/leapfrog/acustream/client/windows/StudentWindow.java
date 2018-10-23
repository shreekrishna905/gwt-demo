package com.leapfrog.acustream.client.windows;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import com.leapfrog.acustream.client.forms.StudentForm;
import com.leapfrog.acustream.shared.Student;

public class StudentWindow extends Window {

	private final StudentForm studentForm;
	
	public StudentWindow(final Student student) {
		studentForm = new StudentForm();
		setHeadingText("Student Information");
		setWidth(550);
		setHeight(300);
		setResizable(false);
		setLayout(new FitLayout());
		final Button btnSave = new Button("Save");
		btnSave.setIconStyle("save");
		btnSave.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				btnSave.setEnabled(false);
				if (studentForm.isValid()) {
					hide(btnSave);
					studentForm.save();
				} else {
					btnSave.setEnabled(true);
				}
			}
		});
		addButton(btnSave);
	}
	
	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);
		add(studentForm);
	}
}
