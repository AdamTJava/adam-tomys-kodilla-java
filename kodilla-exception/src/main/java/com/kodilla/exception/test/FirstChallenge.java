package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        //try {
        //    double result = a / b;
            if (b == 0){
                throw new ArithmeticException();
            }
            return a / b;//return result;
        //} catch (ArithmeticException exception) {
        //    System.out.println("Don't divide by 0 !");
        //} finally {
        //    System.out.println("Division finished.");
        //}
        //return 0;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();
        //System.out.println(firstChallenge.divide(3, 0));

        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException exception) {
            System.out.println("Don't divide by 0 !");
        } finally {
            System.out.println("Division finished.");
        }


    }
}
