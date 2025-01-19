package com.tarique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarique.model.Student;
import com.tarique.model.dto.StudentDto;
import com.tarique.repository.StudentRepository;
import com.tarique.response.JsonResponse;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public JsonResponse findAllStudent() {
		List<Student> students = studentRepository.findAll();
		return new JsonResponse(students, JsonResponse.SUCCESS, JsonResponse.STATUS_CODE_200);
	}
	
	public JsonResponse createStudent(StudentDto student) {
		if(studentRepository.createStudent(student)==1) {
			return new JsonResponse(student, JsonResponse.SUCCESS, "Student created successfully.", JsonResponse.STATUS_CODE_201);
		}
		return null;
	}

}
