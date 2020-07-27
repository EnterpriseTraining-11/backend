package com.github.hieheihei.hotel.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result<T> {

    private String status;      //{"OK","ERROR"}
    private String message;

    private T model;
    private List<T> models;

    private Map<String, Integer> intMap = new HashMap<>();
    private Map<String, Double> doubleMap = new HashMap<>();
    private Map<String, String> stringMap = new HashMap<>();


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public List<T> getModels() {
        return models;
    }

    public void setModels(List<T> models) {
        this.models = models;
    }

    public Map<String, Integer> getIntMap() {
        return intMap;
    }

    public void setIntMap(Map<String, Integer> intMap) {
        this.intMap = intMap;
    }

    public Map<String, Double> getDoubleMap() {
        return doubleMap;
    }

    public void setDoubleMap(Map<String, Double> doubleMap) {
        this.doubleMap = doubleMap;
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }
}
