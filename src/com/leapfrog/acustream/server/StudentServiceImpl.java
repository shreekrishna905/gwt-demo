package com.leapfrog.acustream.server;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.leapfrog.acustream.client.services.StudentService;
import com.leapfrog.acustream.rest.EndPoint;
import com.leapfrog.acustream.rest.RestAPI;
import com.leapfrog.acustream.shared.Student;
import com.leapfrog.acustream.utils.Mapper;

@SuppressWarnings("serial")
public class StudentServiceImpl extends RemoteServiceServlet implements StudentService {

	Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Override
	public List<Student> loadItems() {
		ObjectMapper mapper = Mapper.getInstance();
		try {
			List<Student> students = mapper.readValue(RestAPI.get(EndPoint.STUDENT),
					new TypeReference<List<Student>>() {
					});
			logger.info("Students Information of size: " + students.size() + " fetched");
			return students;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return Collections.emptyList();
	}

	@Override
	public Student save(Student student) {
		ObjectMapper mapper = Mapper.getInstance();
		Student response = null;
		try{
			String data = mapper.writeValueAsString(student);
			response = mapper.readValue(RestAPI.post(EndPoint.STUDENT, data), Student.class);
			logger.info("Student saved with id:" + response.getId());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return response;
	}

}
