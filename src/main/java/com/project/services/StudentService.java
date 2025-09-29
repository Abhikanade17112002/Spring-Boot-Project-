package com.project.services;

import com.project.DTOs.StudentResponseDTO;
import com.project.entities.Student;
import com.project.repositories.StudentRepository;
import com.project.utility.StudentUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository ;
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> retrivedStudentEntityList = studentRepository.findAll() ;
        return StudentUtility.convertStudentEntityListToStudentResponseDTOList(retrivedStudentEntityList);
    }

    public StudentResponseDTO addStudent(Student student) {

        student.setUserName(
                student.getFirstName()+"."+student.getLastName() +"@"+ (int) (Math.random() * 1000)
        );
        System.out.println("Received Student ==> " + student);

        return StudentUtility.convertStudentEntityToStudentResponseDTO(
                studentRepository.save(
                        student
                )
        ) ;

    }

    public StudentResponseDTO getStudentById(String studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student with ID " + studentId + " not found"));

        return StudentUtility.convertStudentEntityToStudentResponseDTO(student);
    }

    public void deleteStudentById(String studentId) {
        System.out.println("Received Student Id ==> " + studentId) ;
        studentRepository.deleteById(studentId);
        return ;
    }

    public StudentResponseDTO replaceStudentById(Student student) {
        System.out.println("Checking Student With Id " + student.getStudentId() + " Exists Or Not ");
        if( !studentRepository.existsById( student.getStudentId()) ){
            throw  new IllegalArgumentException("Student With " + student.getStudentId() + " Does Not Exists") ;
        }
        return   StudentUtility.convertStudentEntityToStudentResponseDTO(studentRepository.save(student) );
    }

    public StudentResponseDTO updateStudentById(Student student) {
        System.out.println("Student ==> " + student );
        System.out.println("Checking Student With Id " + student.getStudentId() + " Exists Or Not ");
        if( !studentRepository.existsById( student.getStudentId()) ){
            throw  new IllegalArgumentException("Student With " + student.getStudentId() + " Does Not Exists") ;
        }

        Student retrivedStudent = studentRepository.findById(student.getStudentId()).orElse(null) ;

        retrivedStudent.setUserName(student.getUserName() != null ? student.getUserName() : retrivedStudent.getUserName());
        retrivedStudent.setEmail(student.getEmail() != null ? student.getEmail() : retrivedStudent.getEmail());
        retrivedStudent.setFirstName(student.getFirstName() != null ? student.getFirstName() : retrivedStudent.getFirstName());
        retrivedStudent.setLastName(student.getLastName() != null ? student.getLastName() : retrivedStudent.getLastName());


        return   StudentUtility.convertStudentEntityToStudentResponseDTO(studentRepository.save(retrivedStudent) );
    }
}
