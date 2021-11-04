package com.harshit.ExcelReadAndStoreInSQL.Repository;

import com.harshit.ExcelReadAndStoreInSQL.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {


}
