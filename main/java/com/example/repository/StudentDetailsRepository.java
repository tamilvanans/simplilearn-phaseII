package com.example.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.vo.StudentDetailsVO;

/**
 * This repository is used for Crud operation of Student
 * @author Tamil  
 *
 */
@Repository
public interface StudentDetailsRepository extends CrudRepository<StudentDetailsVO, Long>{

	@Override
	@org.springframework.data.jpa.repository.Query(
			  value = "select SCR.ID ID, ST.NAME roll_no, CL.CLASS_DESC class_id, SUB.SUBJECT subject_id from STUDENT_CLASS_RLTNSHP SCR, STUDENTS ST, CLASSES CL, SUBJECTS SUB \r\n"
				  		+ "WHERE SCR.ROLL_NO = ST.ROLL_NO\r\n"
				  		+ "AND SCR.CLASS_ID = CL.CLASS_ID\r\n"
				  		+ "AND SCR.SUBJECT_ID = SUB.SUBJECT_ID", 
				  nativeQuery = true)
	Iterable<StudentDetailsVO> findAll();
	
	@Modifying
	@org.springframework.data.jpa.repository.Query(
			  value = "DELETE STUDENT_CLASS_RLTNSHP SCR\r\n"
				  		+ "WHERE SCR.ID = ?", 
				  nativeQuery = true)
	void deleteById(Long Id);
	
	@Query(value = "SELECT STUD_CLS_RLTN_SEQ.nextval FROM DUAL", nativeQuery = true)
	Long getNextSeriesId();
}
