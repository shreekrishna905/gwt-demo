package com.leapfrog.acustream.client.forms;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.leapfrog.acustream.client.AcustreamConstants;
import com.leapfrog.acustream.client.services.StudentServiceAsync;
import com.leapfrog.acustream.shared.Student;

public class StudentForm extends FormPanel {

	private TextField<String> firstName;
	
	private TextField<String> middleName;
	
	private TextField<String> lastName;
	
	private TextField<String> age;
	
	private TextField<String> phone;
	
	private TextArea address;
	
	private TextField<String> city;
	
	public StudentForm() {
		firstName = new TextField<>();
		firstName.setAllowBlank(false);
		middleName = new TextField<>();
		middleName.setAllowBlank(true);
		lastName = new TextField<>();
		lastName.setAllowBlank(false);
		age = new TextField<>();
		age.setAllowBlank(false);
		phone = new TextField<>();
		address = new TextArea();
		address.setAllowBlank(false);
		city = new TextField<>();
		setHeaderVisible(false);
		createForm();
	}
	
	private void createForm(){
		setFrame(true);
		setButtonAlign(HorizontalAlignment.RIGHT);
		LayoutContainer main = new LayoutContainer();
		main.setLayout(new ColumnLayout());
		
		FormData formData = new FormData("100%");
		/* Left Side Container */
		LayoutContainer left = new LayoutContainer();
		left.setStyleAttribute("paddingRight", "5px");
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		left.setLayout(layout);

		firstName.setFieldLabel("First Name");
		left.add(firstName, formData);

		lastName.setFieldLabel("Last Name");
		left.add(lastName, formData);

		phone.setFieldLabel("Phone");
		left.add(phone, formData);

		/* Right Side Container */
		LayoutContainer right = new LayoutContainer();
		right.setStyleAttribute("paddingLeft", "5px");
		layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		right.setLayout(layout);

		middleName.setFieldLabel("Middle Name");
		right.add(middleName, formData);

		age.setFieldLabel("Age");
		right.add(age, formData);

		city.setFieldLabel("City");
		right.add(city, formData);

		main.add(left, new ColumnData(.5));
		main.add(right, new ColumnData(.5));

		add(main, formData);

		/* Comment Section Container */
		LayoutContainer southLayout = new LayoutContainer();
		layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		southLayout.setLayout(layout);

		address.setFieldLabel("Address");
		southLayout.add(address, formData);
		
		add(southLayout, formData);
	}
	
	public void save() {
		
		final Student student = new Student();
		student.setFirstName(firstName.getValue());
		student.setMiddleName(middleName.getValue());
		student.setLastName(lastName.getValue());
		student.setCity(city.getValue());
		student.setAddress(address.getValue());
		student.setPhone(phone.getValue());
		student.setAge(age.getValue());
		
		final StudentServiceAsync studentService = Registry.get(AcustreamConstants.STUDENT_SERVICE);
		
		studentService.save(student, new AsyncCallback<Student>() {
			@Override
			public void onFailure(Throwable caught) {
				Info.display("Info", "Failed to save student: " + student.getFirstName());
			}
			@Override
			public void onSuccess(Student result) {
				Info.display("Info", "Student " + result.getFirstName() + " saved sucessfully");
				final ListStore<ModelData> studentStore = Registry.get(AcustreamConstants.STUDENT_STORE);
				studentStore.add(result);
			}
		});
	}
	
	
	
	
	
}
