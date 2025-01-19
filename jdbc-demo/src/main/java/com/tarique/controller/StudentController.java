package com.tarique.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarique.model.dto.StudentDto;
import com.tarique.response.JsonResponse;
import com.tarique.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public JsonResponse findAllStudent() {
		return studentService.findAllStudent();
	}
	
	@PostMapping
	public JsonResponse createStudent(@RequestBody StudentDto student) {
		return studentService.createStudent(student);
	}

}
