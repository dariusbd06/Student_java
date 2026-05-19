import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {
    private String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Studenti");

        // Header
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Matricol");
        header.createCell(1).setCellValue("Prenume");
        header.createCell(2).setCellValue("Nume");
        header.createCell(3).setCellValue("Grupa");
        header.createCell(4).setCellValue("Nota");

        // Date
        int rowNum = 1;
        for (Student s : studenti) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(s.getNumărMatricol());
            row.createCell(1).setCellValue(s.getPrenume());
            row.createCell(2).setCellValue(s.nume);
            row.createCell(3).setCellValue(s.getFormațieDeStudiu());
            row.createCell(4).setCellValue(s.getNota());
        }

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();
            workbook.close();
            System.out.println("=== Studenti exportati in " + fileName + " ===");
        } catch (Exception e) {
            System.out.println("Eroare la scriere xlsx: " + e.getMessage());
        }
    }
}