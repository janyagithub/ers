package com.janya.mvrg.ers.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class MasterCollegeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Name is mandatory")
	@Column(name = "clg_name")
	private String clgName;

	@NotBlank(message = "Email is mandatory")
	@Column(name = "clg_addr")
	private String clgAddr;

	@Column(name = "phone_no")
	private long phoneNo;

	@Column(name = "fax")
	private String fax;

	@Column(name = "website")
	private String website;

	@Column(name = "logo_name")
	private String logoName;

	@Column(name = "email")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClgName() {
		return clgName;
	}

	public void setClgName(String clgName) {
		this.clgName = clgName;
	}

	public String getClgAddr() {
		return clgAddr;
	}

	public void setClgAddr(String clgAddr) {
		this.clgAddr = clgAddr;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}