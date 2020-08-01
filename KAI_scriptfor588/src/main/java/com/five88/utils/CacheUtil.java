package com.five88.utils;

import com.five88.models.excel.TestData;

import java.util.HashMap;
import java.util.Map;

public class CacheUtil {

    private static CacheUtil instance;

    public static CacheUtil getInstance() {
        if (instance == null)
            instance = new CacheUtil();
        return instance;
    }

    private Map<String, TestData> hashMap = new HashMap<>();

    public Map<String, TestData> getHashMap() {
        return hashMap;
    }

    public void setHashMap(Map<String, TestData> hashMap) {
        this.hashMap = hashMap;
    }
}
