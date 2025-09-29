package com.project.DTOs;


import org.springframework.stereotype.Component;

@Component
public class StudentResponseDTO {
    private String studentId ;

    private String studentName ;
    private String userName ;

    private String email ;

    public StudentResponseDTO() {
    }

    public StudentResponseDTO(String studentId , String studentName , String userName, String email) {
        this.studentId = studentId;
        this.studentName = studentName ;
        this.userName = userName;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentResponseDTO{" +
                "Student Id='" + studentId + '\'' +
                ", Name='" + getStudentName()+ '\'' +
                ", User Name='" + getUserName() + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}
