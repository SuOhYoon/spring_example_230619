package com.example.lesson07.entity;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 객체를 출력할 때 모든 내용이 보여짐.
@AllArgsConstructor // 생성자 생성(모든 파라미터 포함)
@NoArgsConstructor // 기본 생성자 생성(파라미터 없음)
@Getter
@Builder(toBuilder = true) // setter의 대용, toBuilder true = 수정 허용
@Entity(name="new_student") // 이 객체는 Entity다. (JPA-DB 사이에 존재)
@Table(name="new_student") // 테이블 명 설정
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // pk 기본값 설정(GenerationType.IDENTITY : auto_increment)
	private int id;
	
	
	private String name;
	
	@Column(name="phoneNumber") // CamelCase인 속성에 반드시 추가
	private String phoneNumber;
	
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp // 시간을 넣지 않아도 현재 시간으로 자동으로 들어감 = SQL의 NOW() 함수와 동일
	@Column(name="createdAt", updatable = false) // updatable = false 업데이트시 변경되지 않도록 설정
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updatedAt")
	private ZonedDateTime updatedAt;
}
