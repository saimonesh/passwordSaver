package com.example.passwordsaver2;

public class EMPTYException extends Exception {
    public String Message="Name Cannot be Empty";
    public EMPTYException() {
        throw new RuntimeException(Message);
    }

    public EMPTYException(String message) {
        try {
            throw new EMPTYException(message);
        } catch (EMPTYException e) {
            e.printStackTrace();
        }
    }

    public EMPTYException(String message, Throwable cause) {
        throw new RuntimeException(message);
    }

    public EMPTYException(Throwable cause) throws EMPTYException {
        throw new EMPTYException(Message);
    }

    protected EMPTYException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        throw new RuntimeException(message);
    }
}
