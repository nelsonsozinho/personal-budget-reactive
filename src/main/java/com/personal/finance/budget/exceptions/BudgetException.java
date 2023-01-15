package com.personal.finance.budget.exceptions;

import java.util.Map;

public class BudgetException extends RuntimeException {

    private int httpStatus;
    private String errorCode;
    private Map<String, String> fields;

    public BudgetException(int httpStatus, String errorCode, String description) {
        super(description);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public BudgetException(int httpStatus, String errorCode, String description, Throwable cause) {
        super(description, cause);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public BudgetException(int httpStatus, String errorCode, String description, Map<String, String> fields, Throwable cause) {
        super(description, cause);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.fields = fields;
    }

    public String getErrorDescription() {
        return getMessage();
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

}
