package com.janya.mvrg.ers.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EventActivityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "event_id")
	private MasterEventEntity MasterEventEntity;

	@OneToOne
	@JoinColumn(name = "activity_id")
	private MasterActivityEntity masterActivityEntity;

	@Column(name = "winner")
	private String winner;

	@Column(name = "runner")
	private String runner;

	@Column(name = "pic")
	private String pic;

	@Column(name = "details")
	private String details;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MasterEventEntity getMasterEventEntity() {
		return MasterEventEntity;
	}

	public void setMasterEventEntity(MasterEventEntity masterEventEntity) {
		MasterEventEntity = masterEventEntity;
	}

	public MasterActivityEntity getMasterActivityEntity() {
		return masterActivityEntity;
	}

	public void setMasterActivityEntity(MasterActivityEntity masterActivityEntity) {
		this.masterActivityEntity = masterActivityEntity;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getRunner() {
		return runner;
	}

	public void setRunner(String runner) {
		this.runner = runner;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}