package com.example.restdemo.service;

import com.example.restdemo.entity.Student;
import com.example.restdemo.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudentInfo(Student student) {
        return studentRepository.save(student);
    }

    public ResponseEntity<Student> getStudentById(int id) {
        Optional<Student> studentInfo =  studentRepository.findById(id);
        if(studentInfo.isPresent()){
            return ResponseEntity.ok(studentInfo.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Student> updateStudentInfo(int id, Student student) {
        Optional<Student> studentInfo =  studentRepository.findById(id);
        if(studentInfo.isPresent()){
            Student existingStudent = studentInfo.get();
            existingStudent.setName(student.getName());
            existingStudent.setAddress(student.getAddress());
            studentRepository.save(existingStudent);
            return ResponseEntity.ok(existingStudent);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public ResponseEntity<Student> deleteStudent(int id) {
        Optional<Student> studentInfo =  studentRepository.findById(id);
        if(studentInfo.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
