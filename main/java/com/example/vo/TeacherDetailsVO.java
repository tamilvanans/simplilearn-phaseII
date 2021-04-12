package com.example.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Teacher_Class_Rltnshp")
public class TeacherDetailsVO {
	
	@Id
	@Column(name="id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TCHR_CLS_RLTN")
    @SequenceGenerator(name="TCHR_CLS_RLTN", sequenceName="TCHR_CLS_RLTN_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(name="class_id")
	private String classId;
	
	@Column(name="emp_id")
	private String empId;
	
	@Column(name="subject_id")
	private String subjectId;

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TeacherDetailsVO [classId=" + classId + ", empId=" + empId + ", subjectId=" + subjectId + "]";
	}
}
