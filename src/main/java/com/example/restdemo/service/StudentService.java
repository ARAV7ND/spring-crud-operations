package com.example.restdemo.service;

import com.example.restdemo.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    Student saveStudentInfo(Student student);
    List<Student> getStudentList();

    ResponseEntity<Student> getStudentById(int id);

    ResponseEntity<Student> updateStudentInfo(int id, Student student);

    ResponseEntity<Student> deleteStudent(int id);
}
