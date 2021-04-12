package com.example.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Student_Class_Rltnshp")
public class StudentDetailsVO {
	
	@Id
	@Column(name="id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUD_CLS_RLTN")
    @SequenceGenerator(name="STUD_CLS_RLTN", sequenceName="STUD_CLS_RLTN_SEQ", allocationSize = 1)
	private Long id;

	@Column(name="class_id")
	private String classId;
	
	@Column(name="roll_no")
	private String rollNo;
	
	@Column(name="subject_id")
	private String subjectId;

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
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
		return "StudentDetailsVO [Id=" + id + ", classId=" + classId + ", rollNo=" + rollNo + ", subjectId=" + subjectId + "]";
	}
}
