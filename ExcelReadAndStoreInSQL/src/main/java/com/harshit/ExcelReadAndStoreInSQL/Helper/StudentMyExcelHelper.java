package com.harshit.ExcelReadAndStoreInSQL.Helper;

import com.harshit.ExcelReadAndStoreInSQL.Entity.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentMyExcelHelper {
    public static boolean checkExcelFormat(MultipartFile file){
        String contentType=file.getContentType();
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return  true;
        }
        else {
            return  false;
        }
    }

    //convert excel to list of students
    public static List<Student> convertExcelToListOfStudent(InputStream is) {
        List<Student>list =new ArrayList<>();
        try {
            XSSFWorkbook workbook=new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("data");
            int rowNo=0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNo==0) {
                    rowNo++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid=0;
                Student student=new Student();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cid) {
                        case 0:
                            student.setStudentId((int)cell.getNumericCellValue());
                            break;
                        case 1:
                            student.setSname(cell.getStringCellValue());
                            break;
                        case 2:
                            student.setFname(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(student);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



}
