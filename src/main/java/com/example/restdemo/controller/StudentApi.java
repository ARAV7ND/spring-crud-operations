package com.example.restdemo.controller;


import com.example.restdemo.entity.Student;
import com.example.restdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApi {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllTheStudents() {
        return studentService.getStudentList();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudentInfo(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudentInfo(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}
