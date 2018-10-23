package com.leapfrog.acustream.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.leapfrog.acustream.shared.Student;

public interface StudentServiceAsync {
	void loadItems(AsyncCallback<List<Student>> callback);
	void save(Student student, AsyncCallback<Student> callback);
}
