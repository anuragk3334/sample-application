package com.example.anurag;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentEntityRepository studentEntityRepository;

	public StudentEntity getStudent(int id) {
		Optional<StudentEntity> findById = studentEntityRepository.findById(id);
		StudentEntity body = findById.get();
		return body;
	}
	
	public List<StudentEntity> getStudentByName(String name) {
		Optional<List<StudentEntity>> findById = studentEntityRepository.findByName(name);
		List<StudentEntity> body = findById.get();
		return body;
	}
	
	public List<StudentEntity> getStudentByNameAndAge(String name,int age) {
		List<StudentEntity> students = studentEntityRepository.findByNameAndAge(name,age);
		//List<StudentEntity> body = findById.get();
		return students;
	}
	
	public void deleteById(int id) {
		studentEntityRepository.deleteById(id);
	}
	
	public StudentEntity createNewStudent(StudentEntity se) {
		
		if(se.getAge()>22) {
			se.setAge(25);
		}
		StudentEntity response = studentEntityRepository.saveAndFlush(se);
		return response;
	}
	
	

	/*public StudentEntity createStudent() {

		StudentEntity student = new StudentEntity();
		student.setAge(22);
		student.setName("Priya");

		StudentEntity saveAndFlush = studentEntityRepository.saveAndFlush(student);

		return saveAndFlush;
	}*/

	public List<StudentEntity> createStudent(List<StudentEntity> student) {
		List<StudentEntity> outputList=new ArrayList<>();
		student.parallelStream().forEach(stud -> {
			StudentEntity saveAndFlush = studentEntityRepository.saveAndFlush(stud);
			outputList.add(saveAndFlush);
		});
       return outputList;
	}

}
