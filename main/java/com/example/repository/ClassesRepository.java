package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vo.ClassVO;

/**
 * This Repository is used to find classes and delete the classes based on class id
 * @author Tamil
 *
 */
public interface ClassesRepository extends JpaRepository<ClassVO, Long>{

	ClassVO findByClassId(String classId);
	int deleteByClassId(String classId);
}
