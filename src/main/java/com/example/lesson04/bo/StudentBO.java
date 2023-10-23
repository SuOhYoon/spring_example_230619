package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// mybatis
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	// JPA
	// input:파라미터들 output:StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) // @UpdateTimeStamp가 있을 경우 생략 가능
				.build();
		
		return studentRepository.save(student);	
	}
	
	// input: id, DreamJob, output:변경된 StudentEntity
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		StudentEntity student = studentRepository.findById(id).orElse(null);
		if (student != null) {
			// 기존값은 유지하고 세팅된 일부값만 변경(dreamJob만 변경) => toBuilder
			student = student.toBuilder()
				.dreamJob(dreamJob)
				.build();
			
			// update
			student = studentRepository.save(student); // db update후 다시 셀렉트 된 결과값
		}
		
		return student; // null 또는 변경된 데이터
	}
	
	// input : id, output:X
	public void deleteStudentById(int id) {
		// 방법 1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if(student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방법 2)
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);	
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
}
