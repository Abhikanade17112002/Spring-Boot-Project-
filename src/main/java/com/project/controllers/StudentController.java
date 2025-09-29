package com.project.controllers;

import com.project.DTOs.StudentResponseDTO;
import com.project.entities.Student;
import com.project.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService ;

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getStudents(){
        List<StudentResponseDTO> retrivedStudentResponseDTOList = new ArrayList<>() ;
        try{
            retrivedStudentResponseDTOList = studentService.getAllStudents() ;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return    ResponseEntity.status(HttpStatus.OK).body(   retrivedStudentResponseDTOList  );
    }


    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent(@RequestBody Student student ){
        StudentResponseDTO studentResponseDTO = null ;
        try{

            studentResponseDTO = studentService.addStudent(
                    student
            ) ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return  ResponseEntity.status(HttpStatus.CREATED).body(  studentResponseDTO  );
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentId(@PathVariable(name = "id") String studentId ){
        StudentResponseDTO studentResponseDTO = null ;
        try{
            studentResponseDTO = studentService.getStudentById(
                    studentId
            ) ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return  ResponseEntity.status(HttpStatus.OK).body(  studentResponseDTO  );
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteStudentById(@PathVariable( name = "id") String studentId){
        try{
            studentService.deleteStudentById( studentId)  ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.noContent().build() ;

    }

    @PutMapping("/{id}")
    public  ResponseEntity<StudentResponseDTO> replaceStudentById(@RequestBody Student student){
        StudentResponseDTO studentResponseDTO = null ;
        try{
         studentResponseDTO = studentService.replaceStudentById(student)  ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResponseDTO) ;

    }

    @PatchMapping("/{id}")
    public  ResponseEntity<StudentResponseDTO> updateStudentById(@RequestBody Student student){
        StudentResponseDTO studentResponseDTO = null ;
        try{
            studentResponseDTO = studentService.updateStudentById(student)  ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResponseDTO) ;

    }
}

