package com.leapfrog.acustream.shared;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	private String id;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("middle_name")
	private String middleName;

	@JsonProperty("last_name")
	private String lastName;

	private String address;

	private String phone;

	private String city;

	private String age;

	public Student() {

	}

	public Student(String firstName, String middleName, String lastName, String address, String phone, String city,
			String age) {
		super();
		set("id", id);
		set("firstName", firstName);
		set("middleName", middleName);
		set("lastName", lastName);
		set("address", address);
		set("phone", phone);
		set("city", city);
		set("age", age);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getCity() {
		return city;
	}

	public String getAge() {
		return age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		set("firstName", firstName);
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
		set("middleName", middleName);
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		set("lastName", lastName);
	}

	public void setAddress(String address) {
		this.address = address;
		set("address", address);
	}

	public void setPhone(String phone) {
		this.phone = phone;
		set("phone",phone);
	}

	public void setCity(String city) {
		this.city = city;
		set("city",city);
	}

	public void setAge(String age) {
		this.age = age;
		set("age",age);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		set("id", id);
	}

}
