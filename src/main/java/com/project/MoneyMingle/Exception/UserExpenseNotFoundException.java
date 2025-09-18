package com.project.MoneyMingle.Exception;

public class UserExpenseNotFoundException extends Exception{
    public UserExpenseNotFoundException() {
        super();
    }

    public UserExpenseNotFoundException(String message) {
        super(message);
    }

    public UserExpenseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
