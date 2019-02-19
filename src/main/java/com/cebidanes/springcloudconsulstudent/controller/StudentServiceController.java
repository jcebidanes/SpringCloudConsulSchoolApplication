package com.cebidanes.springcloudconsulstudent.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cebidanes.springcloudconsulstudent.domain.Student;

@RestController
public class StudentServiceController {

	private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();
	
	static {
		schooDB = new HashMap<String, List<Student>>();
		
		List<Student> lst = new ArrayList<Student>();
		
		Student sdt = new Student("Sajal", "Class IV");
		lst.add(sdt);
		
		sdt = new Student("Lokesh", "Class V");
		lst.add(sdt);
		
		sdt = new Student("Asush", "Class IV");
		lst.add(sdt);
		
		schooDB.put("abcschool", lst);
		
		lst = new ArrayList<Student>();
		sdt = new Student("Kajal", "Class III");
		lst.add(sdt);
		sdt = new Student("Sukesh", "Class VI");
		lst.add(sdt);
		
		schooDB.put("xyzschool", lst);
	
	}
	
	@RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname) {
		
		List<Student> studentList = schooDB.get(schoolname);
		
		if (studentList == null) {
			studentList = new ArrayList<Student>();
			Student std = new Student("Not Found", "N/A");
			studentList.add(std);
		}
		
		return studentList;
	}
	
	@RequestMapping(value = "/getCountStudent/{schoolname}", method = RequestMethod.GET)
	public Integer getCountStudents(@PathVariable String schoolname) {
		
		Integer countStudent = 0;
		List<Student> studentList = schooDB.get(schoolname);
		
		if (studentList != null) {
			countStudent = studentList.size();
		}
		
		return countStudent;
	}
	
	
	
}
