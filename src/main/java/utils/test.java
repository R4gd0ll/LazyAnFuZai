package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class test {

    public static void main(String[] args) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // 创建一个单元格并设置其值
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("应对登录的用户进行身份标识和鉴别，身份标识具有唯一性，身份鉴别信息具有复杂度要求并定期更换。");
// 创建一个单元格样式
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置文本水平居中
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置文本垂直居中
            cellStyle.setWrapText(true); // 设置文本换行

            // 将样式应用于单元格
            cell.setCellStyle(cellStyle);

            // 设置列宽自适应
            sheet.autoSizeColumn(0);
            // 创建一个单元格样式
            cellStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0.00"));

            // 将样式应用于单元格
            cell.setCellStyle(cellStyle);

            // 将工作簿写入文件
            try (FileOutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}