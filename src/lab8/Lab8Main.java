package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Lab8Main {

    static final String INPUT_FILE = "laborator8_input.xlsx";


    public static void citesteSiAfiseaza() throws Exception {
        FileInputStream fis = new FileInputStream(INPUT_FILE);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        System.out.println("=== 8.5.1 Continutul fisierului ===");
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.NUMERIC) {
                    System.out.print((int) cell.getNumericCellValue() + "\t");
                } else {
                    System.out.print(cell.getStringCellValue() + "\t");
                }
            }
            System.out.println();
        }
        workbook.close();
        fis.close();
    }


    public static void genereazaOutput2() throws Exception {
        FileInputStream fis = new FileInputStream(INPUT_FILE);
        Workbook workbookIn = new XSSFWorkbook(fis);
        Sheet sheetIn = workbookIn.getSheetAt(0);

        Workbook workbookOut = new XSSFWorkbook();
        Sheet sheetOut = workbookOut.createSheet("Sheet1");

        int rowNum = 0;
        for (Row rowIn : sheetIn) {
            Row rowOut = sheetOut.createRow(rowNum);
            int colNum = 0;

            for (Cell cellIn : rowIn) {
                Cell cellOut = rowOut.createCell(colNum);
                if (cellIn.getCellType() == CellType.NUMERIC) {
                    cellOut.setCellValue(cellIn.getNumericCellValue());
                } else {
                    cellOut.setCellValue(cellIn.getStringCellValue());
                }
                colNum++;
            }


            if (rowNum == 0) {
                rowOut.createCell(colNum).setCellValue("Medie");
            } else {
                double nota1 = rowIn.getCell(3).getNumericCellValue();
                double nota2 = rowIn.getCell(4).getNumericCellValue();
                double nota3 = rowIn.getCell(5).getNumericCellValue();
                double medie = (nota1 + nota2 + nota3) / 3.0;
                rowOut.createCell(colNum).setCellValue(medie);
            }
            rowNum++;
        }

        FileOutputStream fos = new FileOutputStream("laborator8_output2.xlsx");
        workbookOut.write(fos);
        fos.close();
        workbookOut.close();
        workbookIn.close();
        fis.close();
        System.out.println("=== 8.5.2 laborator8_output2.xlsx generat! ===");
    }


    public static void genereazaOutput3() throws Exception {
        FileInputStream fis = new FileInputStream(INPUT_FILE);
        Workbook workbookIn = new XSSFWorkbook(fis);
        Sheet sheetIn = workbookIn.getSheetAt(0);

        Workbook workbookOut = new XSSFWorkbook();
        Sheet sheetOut = workbookOut.createSheet("Sheet1");

        int rowNum = 0;
        for (Row rowIn : sheetIn) {
            Row rowOut = sheetOut.createRow(rowNum);
            int colNum = 0;

            for (Cell cellIn : rowIn) {
                Cell cellOut = rowOut.createCell(colNum);
                if (cellIn.getCellType() == CellType.NUMERIC) {
                    cellOut.setCellValue(cellIn.getNumericCellValue());
                } else {
                    cellOut.setCellValue(cellIn.getStringCellValue());
                }
                colNum++;
            }


            if (rowNum == 0) {
                rowOut.createCell(colNum).setCellValue("Medie");
            } else {
                int excelRow = rowNum + 1;
                rowOut.createCell(colNum).setCellFormula("AVERAGE(D" + excelRow + ":F" + excelRow + ")");
            }
            rowNum++;
        }

        FileOutputStream fos = new FileOutputStream("laborator8_output3.xlsx");
        workbookOut.write(fos);
        fos.close();
        workbookOut.close();
        workbookIn.close();
        fis.close();
        System.out.println("=== 8.5.3 laborator8_output3.xlsx generat! ===");
    }

    public static void main(String[] args) throws Exception {
        citesteSiAfiseaza();
        genereazaOutput2();
        genereazaOutput3();
    }
}