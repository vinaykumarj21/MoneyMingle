package com.project.MoneyMingle.Exception;

public class ExpenseNotFoundException extends Exception{
    public ExpenseNotFoundException() {
        super();
    }

    public ExpenseNotFoundException(String message) {
        super(message);
    }

    public ExpenseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
