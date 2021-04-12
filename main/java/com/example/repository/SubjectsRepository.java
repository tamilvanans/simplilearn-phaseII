package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vo.SubjectVO;

public interface SubjectsRepository extends JpaRepository<SubjectVO, Long> {

	SubjectVO findBySubjectId(String subjectId);

	int deleteBySubjectId(String subjectId);
}
