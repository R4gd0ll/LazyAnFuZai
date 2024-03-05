package System;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class writeToXlsx {
    public static void createXlsx(String pwd) {
        // 创建一个新的工作簿
        Workbook workbook = new XSSFWorkbook();

        // 创建一个工作表
        Sheet sheet = workbook.createSheet("Sheet1");

        // 创建一行，并在该行中创建单元格并写入数据
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置文本水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置文本垂直居中
        cellStyle.setWrapText(true); // 设置文本换行
        // 将样式应用于单元格
        cell.setCellStyle(cellStyle);
        // 设置列宽自适应

        // 写入数据到xlsx文件
        try (FileOutputStream fileOut = new FileOutputStream(pwd)) {
            workbook.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭工作簿
        try {
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("xlsx文件创建成功！");
    }
    public static void writeXlsx(String pwd,int rowInt,int cellInt,String fintName,String value){
        try (FileInputStream fis = new FileInputStream(pwd);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet("Sheet1");
            sheet.setColumnWidth(1, 10000);
            sheet.setColumnWidth(2, 8000);
            sheet.setColumnWidth(3, 10000);
            Font font = workbook.createFont();
            font.setFontName(fintName);
            font.setFontHeightInPoints((short) 12);
//
            CellStyle style = workbook.createCellStyle();
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style.setAlignment(HorizontalAlignment.CENTER); // 设置文本水平居中
            style.setVerticalAlignment(VerticalAlignment.CENTER); // 设置文本垂直居中
            style.setWrapText(true); // 设置文本换行
            style.setFont(font);

            Row row = sheet.getRow(rowInt);
            if (row == null) {
                row = sheet.createRow(rowInt);
            }else{
                row.setHeightInPoints(100);

            }

            Cell cell = row.getCell(cellInt);
            if (cell == null) {
                cell = row.createCell(cellInt);
            }

            cell.setCellValue(value);
            cell.setCellStyle(style);

            try (FileOutputStream fileOut = new FileOutputStream(pwd)) {
                workbook.write(fileOut);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
