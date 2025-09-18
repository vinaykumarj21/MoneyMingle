package com.project.MoneyMingle.Exception;

public class GroupNotFoundException extends Exception {
    public GroupNotFoundException() {
        super();
    }

    public GroupNotFoundException(String message) {
        super(message);
    }

    public GroupNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
