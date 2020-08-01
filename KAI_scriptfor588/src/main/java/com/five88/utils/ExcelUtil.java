package com.five88.utils;

import com.five88.models.excel.TestData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("all")
public class ExcelUtil {

    private static ExcelUtil instance;
    private String pathFile;

    public static ExcelUtil getInstance() {

        if (instance == null)
            instance = new ExcelUtil();

        return instance;
    }

    private ExcelUtil() {
        pathFile = Constant.FIVE88_TESTCASE_FILE;
    }

    public void loadDataFromExcelOnCache(String sheetName) {
        Map<String, TestData> hashMap = CacheUtil.getInstance().getHashMap();

        try {
            File file = new File(pathFile);
            Util.log(file.getAbsolutePath());

            FileInputStream inputStream = new FileInputStream(file);

            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheet(sheetName);
            Iterator<Row> iterator = firstSheet.iterator();

            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            String text = cell.getStringCellValue();
                            if (check(text, Constant.KEY_TC)) {

                                Cell data = cellIterator.next();
                                String description = data.getStringCellValue().trim();

                                data = cellIterator.next();
                                String needCondition = data.getStringCellValue().trim();

                                data = cellIterator.next();
                                String steps = data.getStringCellValue().trim();

                                data = cellIterator.next();
                                String expected = data.getStringCellValue().trim();

                                TestData testData = new TestData(text, description, needCondition, steps, expected);
                                if (!hashMap.containsKey(text)) hashMap.put(text.toLowerCase(), testData);

                                continue;
                            }
                            break;
                    }
                }
            }

            workbook.close();
            inputStream.close();
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
    }

    private boolean check(String text, String[] arr) {
        for (String s : arr) {
            if (text.toLowerCase().contains(s))
                return true;
        }
        return false;
    }
}
