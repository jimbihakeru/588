package com.five88.models.excel;

public class TestData {
    public String testName;
    public String description;
    public String needCondition;
    public String steps;
    public String expected;

    public TestData(String testName, String description, String needCondition, String steps, String expected){
        this.testName = testName;
        this.description = description;
        this.needCondition = needCondition;
        this.steps = steps;
        this.expected = expected;
    }
}
