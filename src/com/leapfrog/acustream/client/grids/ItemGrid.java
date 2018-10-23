package com.leapfrog.acustream.client.grids;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.leapfrog.acustream.client.AcustreamConstants;
import com.leapfrog.acustream.client.services.StudentServiceAsync;
import com.leapfrog.acustream.shared.Student;

public class ItemGrid extends LayoutContainer {

	public static final String ITEM_GRID = "item_grid";
	
	private EditorGrid<BaseModel> grid;
	
	final StudentServiceAsync studentService = Registry.get(AcustreamConstants.STUDENT_SERVICE);
	
	public ItemGrid() {
		setLayout(new FitLayout());
	}

	@Override
	protected void onRender(Element parent, int index) {
		
		final List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		
		columns.add(new ColumnConfig("firstName", "First Name", 200));
		columns.add(new ColumnConfig("middleName", "Middle Name", 200));
		columns.add(new ColumnConfig("lastName", "Last Name", 200));
		
		ColumnConfig column = new ColumnConfig();
		column.setId("address");
		column.setHeaderHtml("Address");
		column.setWidth(200);
		column.setSortable(false);
		column.setEditor(getEditor());
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("phone");
		column.setHeaderHtml("Phone");
		column.setWidth(200);
		column.setSortable(false);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("city");
		column.setHeaderHtml("City");
		column.setWidth(200);
		column.setSortable(false);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("age");
		column.setHeaderHtml("Age");
		column.setWidth(200);
		column.setSortable(false);
		columns.add(column);
		

		final ColumnModel columnModel = new ColumnModel(columns);
		
		RpcProxy<List<Student>> proxy = new RpcProxy<List<Student>>() {
			@Override
			protected void load(Object loadConfig, AsyncCallback<List<Student>> callback) {
				studentService.loadItems(callback);
			}
		};
		ListLoader<ListLoadResult<Student>> loader = new BaseListLoader<ListLoadResult<Student>>(proxy);
		ListStore<ModelData> itemStore = new ListStore<ModelData>(loader);
		Registry.register(AcustreamConstants.STUDENT_STORE, itemStore);
		grid = new EditorGrid<BaseModel>(itemStore, columnModel);
		loader.load();
		grid.setBorders(true);
		grid.setAutoHeight(true);
		grid.getView().setForceFit(true); 
		grid.setStripeRows(true);
		Registry.register(ITEM_GRID, grid);
		add(grid);
		super.onRender(parent, index);
	}

	private CellEditor getEditor() {
		final TextField<String> text = new TextField<String>();
		CellEditor editor = new CellEditor(text);
		return editor;
	}

	
}
