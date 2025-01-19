package com.tarique.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tarique.model.Student;
import com.tarique.model.dto.StudentDto;

@Repository
public class StudentRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Student> findAll() {
		List<Student> students = new ArrayList<>();
		List<Map<String, Object>> findAll = jdbcTemplate.queryForList("select * from student");
		for (Map<String, Object> row : findAll) {
			Student student = new Student();
			student.setId((Integer) row.get("id"));
			student.setName((String) row.get("name"));
			student.setEmail((String) row.get("email"));
			student.setRoll((String) row.get("roll"));
			student.setAddress((String) row.get("address"));
			students.add(student);
		}

		return students;
	}

	public int createStudent(StudentDto student) {
		String sql = "insert into student(name,email,roll,addess) values(?,?,?,?)";
		return jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getRoll(), student.getAddress());
	}

}
