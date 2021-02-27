package com.janya.mvrg.ers.enitity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class MasterEventEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Name is mandatory")
	@Column(name = "event_name")
	private String eventName;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "reg_start_date")
	private Date regStartndDate;

	@Column(name = "reg_end_date")
	private Date regEndDate;

	@OneToOne
	@JoinColumn(name = "created_by")
	private MasterCollegeEntity createdByMasterCollegeEntity;

	@Column(name = "event_loc")
	private String eventLoc;

	@Column(name = "event_desc", length = 400)
	private String eventDescription;

	@Column(name = "event_corrosal_pic")
	private String eventCorrosalpic;

	public MasterEventEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MasterEventEntity(Long id, @NotBlank(message = "Name is mandatory") String eventName) {
		super();
		this.id = id;
		this.eventName = eventName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getRegStartndDate() {
		return regStartndDate;
	}

	public void setRegStartndDate(Date regStartndDate) {
		this.regStartndDate = regStartndDate;
	}

	public Date getRegEndDate() {
		return regEndDate;
	}

	public void setRegEndDate(Date regEndDate) {
		this.regEndDate = regEndDate;
	}

	public MasterCollegeEntity getCreatedByMasterCollegeEntity() {
		return createdByMasterCollegeEntity;
	}

	public void setCreatedByMasterCollegeEntity(MasterCollegeEntity createdByMasterCollegeEntity) {
		this.createdByMasterCollegeEntity = createdByMasterCollegeEntity;
	}

	public String getEventLoc() {
		return eventLoc;
	}

	public void setEventLoc(String eventLoc) {
		this.eventLoc = eventLoc;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventCorrosalpic() {
		return eventCorrosalpic;
	}

	public void setEventCorrosalpic(String eventCorrosalpic) {
		this.eventCorrosalpic = eventCorrosalpic;
	}

}