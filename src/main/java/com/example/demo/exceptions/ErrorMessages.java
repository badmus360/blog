package com.example.demo.exceptions;

public enum ErrorMessages {
    MISSING_REQUIRED_FIELD("Missing required field(s)."),
    RECORD_ALREADY_EXIST("Record already exist."),
    INCORRECT_LOGIN_DETAILS("Incorrect login details."),
    NO_RECORD_FOUND("No record found."),
    FILL_THE_REQUIRED_DETAILS("Fill the required details."),
    WRONG_USER_ID("User does not exist.");



    private String errorMessages;

    ErrorMessages(String errorMessages){
        this.errorMessages = errorMessages;
    }

   public String getErrorMessages(){
        return errorMessages;
   }

   public void setErrorMessages(String errorMessages){
        this.errorMessages = errorMessages;
   }
}
