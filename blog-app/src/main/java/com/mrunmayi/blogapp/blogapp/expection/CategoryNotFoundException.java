package com.mrunmayi.blogapp.blogapp.expection;

public class CategoryNotFoundException extends RuntimeException {
    private String resourceName;

    private String fieldName;

    private Integer fieldValue;

    public CategoryNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
