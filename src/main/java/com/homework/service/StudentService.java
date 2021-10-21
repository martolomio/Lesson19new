package com.homework.service;

import com.homework.domain.Student;
import com.homework.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student create(Student student, MultipartFile file) throws IOException {
        student.setFileName(StringUtils.cleanPath(file.getOriginalFilename()));
        student.setFileType(file.getContentType());
        student.setFileData(file.getBytes());
        return studentRepository.save(student);
    }

    public Student findById(int id){
        return  studentRepository.getById(id);
    }


}
