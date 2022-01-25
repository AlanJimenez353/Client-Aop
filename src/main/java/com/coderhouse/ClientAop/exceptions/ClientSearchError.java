package com.coderhouse.ClientAop.exceptions;

public class ClientSearchError extends Exception{
    private String message;

    public ClientSearchError(String message){
        super(message);
    }

}
