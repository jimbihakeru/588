package com.five88;

import com.five88.utils.Constant;
import com.five88.utils.ExcelUtil;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

public class Five88 {

    public static void main(String[] args) {
        init();
        runTestNG();
    }

    private static void init() {
        ExcelUtil excelUtil = ExcelUtil.getInstance();
        excelUtil.loadDataFromExcelOnCache(Constant.FIVE88_TESTCASE_SHEET);
    }

    private static void runTestNG() {
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();

        String fileName, subPath = "";

        fileName = "/" + Constant.FIVE88_SUITE;

        if (Constant.DEBUG)
            subPath = "/src/main/resources/suites";

        String path = String.format(".%s%s", subPath, fileName);
        suites.add(path);

        testng.setTestSuites(suites);
        testng.run();
    }
}
