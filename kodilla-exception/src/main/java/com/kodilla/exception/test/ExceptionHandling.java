package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(3, 5));
            System.out.println("Arguments X and Y are correct.");
        } catch (Exception e) {
            System.out.println("Argument X must be bigger than or equal 1 and smaller than 2 ! \nArgument Y must be different than 1.5 !");
        }

    }
}
