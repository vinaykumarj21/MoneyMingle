package com.project.Splitwise.Exception;

public class UserExpenseNotFoundException extends Exception{
    public UserExpenseNotFoundException() {

    }

    public UserExpenseNotFoundException(String message) {
        super(message);
    }

    public UserExpenseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
