package com.personal.finance.budget.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.HttpURLConnection;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends BudgetException {

    public ResourceNotFoundException(String msg) {
        super(HttpURLConnection.HTTP_NOT_FOUND, "resource_not_found", msg);
    }

    public ResourceNotFoundException(String errorCode, String description) {
        super(HttpStatus.NOT_FOUND.value(), errorCode, description);
    }

}
