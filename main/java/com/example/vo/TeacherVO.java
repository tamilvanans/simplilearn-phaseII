package com.example.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Teachers")
public class TeacherVO {

	@Id
	@Column(name="emp_id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String staffId;
	
	@Column(name="name")
	private String staffName;

	
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}


}
