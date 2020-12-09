package com.kodilla.hibernate.manytomany.facade;

public class SearchException extends Exception{
    public static String ERR_NO_COMPANY = "Company not found";
    public static String ERR_NO_EMPLOYEE = "Employee not found";

    public SearchException(String message) {
        super(message);
    }
}
