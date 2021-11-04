package com.harshit.ExcelReadAndStoreInSQL.Controller;

import com.harshit.ExcelReadAndStoreInSQL.Entity.Student;
import com.harshit.ExcelReadAndStoreInSQL.Helper.StudentMyExcelHelper;
import com.harshit.ExcelReadAndStoreInSQL.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student/upload")
    public ResponseEntity<?> upload (@RequestParam("file")MultipartFile file) {
        if(StudentMyExcelHelper.checkExcelFormat(file)) {
            studentService.save(file);
            return ResponseEntity.status(HttpStatus.OK).body("File data saved in Database");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only");
    }

    @GetMapping("/student")
    public List<Student> getAllStudent() {
       return studentService.getAllStudents();
    }

}
