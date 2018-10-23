package com.leapfrog.acustream.client.forms;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

public class RebuttalForm extends FormPanel {

	LabelField organization = new LabelField();
	LabelField dos = new LabelField();
	LabelField status = new LabelField();
	LabelField missingId = new LabelField();
	LabelField clientUser = new LabelField();
	LabelField clientAuditDate = new LabelField();
	LabelField auditor = new LabelField();

	LabelField acustreamComment = new LabelField();
	LabelField clientComment = new LabelField();
	TextArea comment = new TextArea();

	Button saveButton = new Button("Save");

	public RebuttalForm() {
		this.setHeaderVisible(false);
		organization.setValue("Leap Frog");
		dos.setValue("2018-03-09");
		status.setValue("RB-TRUE");
		missingId.setValue("989834");
		clientUser.setValue("Ram Krishna");
		clientAuditDate.setValue("2019-03-8");
		auditor.setValue("Shyam Krishna");
		acustreamComment.setValue(
				"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam");
		clientComment.setValue(
				"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, que porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem,  voluptatem accusantium doloremque laudantium, totam rem aperiam, que porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut  voluptatem accusantium doloremque laudantium, totam rem aperiam, que porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut ");
		comment.setValue("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam,Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam");
		createForm();
	}

	private void createForm() {
		setStyleName("rebuttal");
		setFrame(true);
		setAutoHeight(true);
		setHeadingText("Client Rebuttal");
		setButtonAlign(HorizontalAlignment.RIGHT);
		LayoutContainer main = new LayoutContainer();
		main.setLayout(new ColumnLayout());

		/* Left Side Container */
		LayoutContainer left = new LayoutContainer();
		left.setStyleAttribute("paddingRight", "5px");
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.LEFT);
		left.setLayout(layout);
		FormData formData = new FormData("100%");

		organization.setFieldLabel("Organization:");
		left.add(organization, formData);

		status.setFieldLabel("Status:");
		left.add(status, formData);

		clientUser.setFieldLabel("Client User:");
		left.add(clientUser, formData);

		auditor.setFieldLabel("Author:");
		left.add(auditor, formData);

		/* Right Side Container */
		LayoutContainer right = new LayoutContainer();
		right.setStyleAttribute("paddingLeft", "5px");
		layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.LEFT);
		right.setLayout(layout);

		dos.setFieldLabel("DOS:");
		right.add(dos, formData);

		missingId.setFieldLabel("Missing ID:");
		right.add(missingId, formData);

		clientAuditDate.setFieldLabel("Client Audit Date:");
		right.add(clientAuditDate, formData);

		main.add(left, new ColumnData(.5));
		main.add(right, new ColumnData(.5));

		add(main, formData);

		/* Comment Section Container */
		LayoutContainer commentLayout = new LayoutContainer();
		layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		commentLayout.setLayout(layout);

		acustreamComment.setFieldLabel("Acustream Comment:");
		commentLayout.add(acustreamComment, formData);

		clientComment.setFieldLabel("Client Comment:");
		commentLayout.add(clientComment, formData);

		comment.setFieldLabel("Comment");
		commentLayout.add(comment, formData);

		add(commentLayout, formData);

		addButton(saveButton);
	}
}
