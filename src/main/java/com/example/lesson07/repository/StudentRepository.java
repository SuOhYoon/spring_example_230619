package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	// 1) Spring Data JPA : JpaRepository<Entity, PK Type>
	
	// save() - insert, update
	// findById() - select
	// delete() - delete
	// findAll() - 전체 조회
	
	// 2) JPQL 문법 - ex02/1
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContaining(String email);
	public List<StudentEntity> findByNameStartingWith(String name);
	public List<StudentEntity> findByIdBetween(int start, int end);
	
	// ex02/2
	// 1) JPQL 엔티티로 조회
	@Query(value="select st from new_student st where st.dreamJob = :dreamJob")
	public List<StudentEntity> findByDreamJob(@Param("dreamJob")String dreamJob);
}
