package com.example.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.vo.TeacherDetailsVO;

@Repository
public interface TeacherDetailsRepository extends CrudRepository<TeacherDetailsVO, Long> {
	@org.springframework.data.jpa.repository.Query(value = "select TCR.ID ID, TR.NAME emp_id, CL.CLASS_DESC class_id, SUB.SUBJECT subject_id from TEACHER_CLASS_RLTNSHP TCR, TEACHERS TR, CLASSES CL, SUBJECTS SUB \r\n"
			+ "WHERE TCR.EMP_ID = TR.EMP_ID\r\n" + "AND TCR.CLASS_ID = CL.CLASS_ID\r\n"
			+ "AND TCR.SUBJECT_ID = SUB.SUBJECT_ID", nativeQuery = true)
	Iterable<TeacherDetailsVO> findAll();

	@Modifying
	@org.springframework.data.jpa.repository.Query(value = "DELETE TEACHER_CLASS_RLTNSHP TCR\r\n"
			+ "WHERE TCR.ID = ?", nativeQuery = true)
	void deleteById(Long Id);

	@Query(value = "SELECT TCHR_CLS_RLTN_SEQ.nextval FROM DUAL", nativeQuery = true)
	Long getNextSeriesId();
}
