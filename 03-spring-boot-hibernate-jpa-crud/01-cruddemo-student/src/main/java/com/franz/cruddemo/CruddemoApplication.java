package com.franz.cruddemo;

import com.franz.cruddemo.dao.StudentDAO;
import com.franz.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents (studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;

		System.out.println("Deleting student id: " +studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

//		retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

//		Change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("Hazel");

//		Update the student
		studentDAO.update(myStudent);

//		Display the updated student
		System.out.println(myStudent);


	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
//		get a list of students

		List<Student> theStudents = studentDAO.findByLastName("Code");

//		display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
//		get a list of students

		List<Student> theStudents = studentDAO.findAll();

//		display list of students

		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

//		create a student object

		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Franz", "Code", "franz@gmail.com");

//		save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

//		display the id of the saved student
		int studentId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + studentId);

//		retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

//		display student
		System.out.println("Found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student ("Frank", "Doe", "john@gmail.com");
		Student tempStudent2 = new Student ("Anro", "Doe", "mary@gmail.com");
		Student tempStudent3 = new Student ("April", "Doe", "bonita@gmail.com");

		// save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student ("Paul", "Doe", "paul@gmail.com");

		// save the student object

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
