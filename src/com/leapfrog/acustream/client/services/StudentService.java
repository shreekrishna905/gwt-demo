package com.leapfrog.acustream.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.leapfrog.acustream.shared.Student;

@RemoteServiceRelativePath("student-service")
public interface StudentService extends RemoteService {
	List<Student> loadItems();
	Student save(Student student);
}
