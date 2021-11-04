package com.harshit.ExcelReadAndStoreInSQL.Service;

import com.harshit.ExcelReadAndStoreInSQL.Entity.Student;
import com.harshit.ExcelReadAndStoreInSQL.Helper.StudentMyExcelHelper;
import com.harshit.ExcelReadAndStoreInSQL.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void save(MultipartFile file) {
        try {
            List<Student> students = StudentMyExcelHelper.convertExcelToListOfStudent(file.getInputStream());
            studentRepo.saveAll(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student>getAllStudents() {
        return studentRepo.findAll();
    }
}
