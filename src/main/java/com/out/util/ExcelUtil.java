package com.out.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.out.model.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by lmy on 2017/6/11.
 */
public class ExcelUtil {

    public static Workbook exportToExcel(String templateName, List<User> users) throws IOException {
        InputStream inputStream = ExcelUtil.class.getResourceAsStream("/"+templateName);
        System.out.println(inputStream);
        POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);
        Workbook workbook = new HSSFWorkbook(fileSystem);
        Sheet sheet = workbook.getSheetAt(0);

        int cellNum = sheet.getRow(0).getLastCellNum();
        int rowIndex = 1;
        for (User user : users) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(user.getInt("id"));
            row.createCell(1).setCellValue(user.getStr("username"));
            row.createCell(2).setCellValue(user.getStr("password"));
            row.createCell(3).setCellValue(user.getStr("name"));
            row.createCell(4).setCellValue(user.getStr("sex"));
            row.createCell(5).setCellValue(user.getInt("tel"));
            row.createCell(6).setCellValue(user.getInt("QQ"));
            row.createCell(7).setCellValue(user.getStr("weixin"));
            row.createCell(8).setCellValue(user.getStr("email"));
            row.createCell(9).setCellValue(user.getInt("grade"));
            row.createCell(10).setCellValue(user.getStr("desc"));
            row.createCell(11).setCellValue(user.getStr("desc"));

        }
        return workbook;
    }

}
