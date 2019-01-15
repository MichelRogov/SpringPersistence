package com.persistence.jpahibernate.controller;

import com.persistence.jpahibernate.exception.StudentNotFoundException;
import com.persistence.jpahibernate.model.student.Student;
import com.persistence.jpahibernate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(!optionalStudent.isPresent()){
            throw new StudentNotFoundException("student not found by id:" + id);
        }

        return optionalStudent.get();
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
    }

    @PostMapping("/students")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent (@RequestBody Student student, @PathVariable long id) {
        Optional<Student> foundStudent = studentRepository.findById(id);

        if(!foundStudent.isPresent()){
            return ResponseEntity.notFound().build();
        }

        student.setId(id);

        studentRepository.save(student);

        return ResponseEntity.noContent().build();
    }
}
