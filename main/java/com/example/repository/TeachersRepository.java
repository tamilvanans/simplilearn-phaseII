package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vo.TeacherVO;

public interface TeachersRepository extends JpaRepository<TeacherVO, Long> {

	TeacherVO findByStaffId(String staffId);

	int deleteByStaffId(String staffId);
}
