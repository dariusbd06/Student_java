
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lab8Studenti {

    static final String XLS_FILE = "laborator8_students.xlsx";


    public static void writeToXls(List<Student> studenti, String filename) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Studenti");


        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Matricol");
        header.createCell(1).setCellValue("Prenume");
        header.createCell(2).setCellValue("Nume");
        header.createCell(3).setCellValue("Grupa");
        header.createCell(4).setCellValue("Nota");


        int rowNum = 1;
        for (Student s : studenti) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(s.getNumărMatricol());
            row.createCell(1).setCellValue(s.getPrenume());
            row.createCell(2).setCellValue(s.nume);
            row.createCell(3).setCellValue(s.getFormațieDeStudiu());
            row.createCell(4).setCellValue(s.getNota());
        }

        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.close();
        workbook.close();
        System.out.println("=== 8.5.4a Studenti exportati in " + filename + " ===");
    }


    public static List<Student> readFromXls(String filename) throws Exception {
        List<Student> studenti = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filename);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);


        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            String matricol = row.getCell(0).getStringCellValue();
            String prenume = row.getCell(1).getStringCellValue();
            String nume = row.getCell(2).getStringCellValue();
            String grupa = row.getCell(3).getStringCellValue();
            double nota = row.getCell(4).getNumericCellValue();

            Student s = new Student(matricol, prenume, nume, grupa);
            s.setNota(nota);
            studenti.add(s);
        }

        workbook.close();
        fis.close();
        System.out.println("=== 8.5.4b Studenti cititi din " + filename + " ===");
        return studenti;
    }

    public static void main(String[] args) throws Exception {

        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("1001", "Ion", "Popescu", "ISM141/1"));
        studenti.get(0).setNota(9.5);
        studenti.add(new Student("1002", "Maria", "Ionescu", "ISM141/1"));
        studenti.get(1).setNota(8.0);
        studenti.add(new Student("1003", "Andrei", "Popa", "TI131/1"));
        studenti.get(2).setNota(7.5);


        writeToXls(studenti, XLS_FILE);


        List<Student> studentsFromXls = readFromXls(XLS_FILE);
        System.out.println("\nStudenti cititi din xlsx:");
        for (Student st : studentsFromXls) {
            System.out.println(st);
        }
    }
}