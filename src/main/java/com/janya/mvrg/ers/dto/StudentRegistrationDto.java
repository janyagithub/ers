package com.janya.mvrg.ers.dto;

public class StudentRegistrationDto {

	private long id;

	private String name;

	private String studentId;

	private String email;

	private Long masterActivityEntityId;

	private Long masterEventEntityId;

	private Long masterCollegeEntityId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMasterActivityEntityId() {
		return masterActivityEntityId;
	}

	public void setMasterActivityEntityId(Long masterActivityEntityId) {
		this.masterActivityEntityId = masterActivityEntityId;
	}

	public Long getMasterEventEntityId() {
		return masterEventEntityId;
	}

	public void setMasterEventEntityId(Long masterEventEntityId) {
		this.masterEventEntityId = masterEventEntityId;
	}

	public Long getMasterCollegeEntityId() {
		return masterCollegeEntityId;
	}

	public void setMasterCollegeEntityId(Long masterCollegeEntityId) {
		this.masterCollegeEntityId = masterCollegeEntityId;
	}

}