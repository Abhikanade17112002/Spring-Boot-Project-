package com.project.utility;

import com.project.DTOs.StudentResponseDTO;
import com.project.entities.Student;
import java.util.List;


public class StudentUtility {

    public static List<StudentResponseDTO>  convertStudentEntityListToStudentResponseDTOList(List<Student> students){


        List<StudentResponseDTO> mappedList = students.stream()
                .map(( student)->{
                    StudentResponseDTO studentResponseDTO = new StudentResponseDTO() ;
                    studentResponseDTO.setStudentId(student.getStudentId());
                    studentResponseDTO.setEmail(student.getEmail());
                    studentResponseDTO.setStudentName(student.getFirstName() + " " + student.getLastName());
                    studentResponseDTO.setUserName(student.getUserName());
                    return studentResponseDTO ;
                })
                .toList();


        return mappedList ;

    }

    public static StudentResponseDTO convertStudentEntityToStudentResponseDTO( Student student ){

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO() ;

        studentResponseDTO.setUserName(student.getUserName());
        studentResponseDTO.setStudentName(student.getFirstName() + " " + student.getLastName() );
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setStudentId(student.getStudentId());


        return  studentResponseDTO ;

    }
}
