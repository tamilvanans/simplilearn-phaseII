package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vo.StudentVO;

@Repository
public interface StudentsRepository extends JpaRepository<StudentVO, Long> {

	StudentVO findByStudentId(String studentId);

	int deleteByStudentId(String studentId);
}
