package com.leapfrog.acustream.client.windows;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import com.leapfrog.acustream.client.forms.RebuttalForm;

public class RebuttalWindow extends Window{

	private final RebuttalForm rebuttalForm;
	
	public RebuttalWindow() {
		setButtonAlign(HorizontalAlignment.LEFT);
		rebuttalForm = new RebuttalForm();
		setHeadingText("Rebuttal Client");
		setAutoHeight(true);
		setWidth(650);
		setHeight(410);
		setResizable(false);
		setLayout(new FitLayout());
	}

	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);
		add(rebuttalForm);
	}
}
