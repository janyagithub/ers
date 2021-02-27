package com.janya.mvrg.ers.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class StudentRegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank(message = "Name is mandatory")
	@Column(name = "name")
	private String name;

	@NotBlank(message = "Name is mandatory")
	private String studentId;

	@Column(name = "email")
	private String email;

	@OneToOne
	@JoinColumn(name = "activity_id")
	private MasterEventEntity masterEventEntity;

	@OneToOne
	@JoinColumn(name = "event_id")
	private MasterActivityEntity masterActivityEntity;

	@OneToOne
	@JoinColumn(name = "clg_id")
	private MasterCollegeEntity masterCollegeEntity;

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

	public MasterEventEntity getMasterEventEntity() {
		return masterEventEntity;
	}

	public void setMasterEventEntity(MasterEventEntity masterEventEntity) {
		this.masterEventEntity = masterEventEntity;
	}

	public MasterActivityEntity getMasterActivityEntity() {
		return masterActivityEntity;
	}

	public void setMasterActivityEntity(MasterActivityEntity masterActivityEntity) {
		this.masterActivityEntity = masterActivityEntity;
	}

	public MasterCollegeEntity getMasterCollegeEntity() {
		return masterCollegeEntity;
	}

	public void setMasterCollegeEntity(MasterCollegeEntity masterCollegeEntity) {
		this.masterCollegeEntity = masterCollegeEntity;
	}

}