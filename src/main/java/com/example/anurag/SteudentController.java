package com.example.anurag;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SteudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<StudentEntity> getStudentEntity(@PathVariable("id")Integer id) {
		
		StudentEntity student = studentService.getStudent(id);
		
		return ResponseEntity.ok(student);
	}
	
	@GetMapping("/studentByName/{nm}")
	public ResponseEntity<List<StudentEntity>> getStudentEntityByName(@PathVariable("nm")String name1){
		
		List<StudentEntity> list = studentService.getStudentByName(name1);
		return ResponseEntity.ok(list);
		
	}
	
	//@GetMapping("/student")
	/*public ResponseEntity<StudentEntity> getStudent() {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudent());
		
	}*/
	
	/*@GetMapping("/cstudent")
	public ResponseEntity<StudentEntity> createStudent() {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(studentService.createStudent());
		
	}*/
	
	@PutMapping("/createstudent")
	public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity se){
		
		StudentEntity response=studentService.createNewStudent(se);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<StudentEntity> createStudent(@PathVariable("id")Integer id){
		
		studentService.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
		
	}
	
	
	@PutMapping("/cstudent")
	public ResponseEntity<List<StudentEntity>> createStudent(@RequestBody List<StudentEntity> list) {
		
		//studentService.createStudent(list);
		return ResponseEntity.status(HttpStatus.OK).body(studentService.createStudent(list));
		
	}
	
	

}
