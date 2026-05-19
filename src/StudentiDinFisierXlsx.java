import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx {
    private String fileName;

    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            // Sarim peste header (randul 0)
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
            System.out.println("=== Studenti cititi din " + fileName + " ===");
        } catch (Exception e) {
            System.out.println("Eroare la citire xlsx: " + e.getMessage());
        }
        return studenti;
    }
}