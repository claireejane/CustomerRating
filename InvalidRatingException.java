// ********************************************
// InvalidRatingException.java
// Claire Jane  T00783917
// COMP 1231 – Assignment 3:
// This  class defines a custom exception used to indicate
// that a customer's rating input is not a valid number.
// ********************************************


public class InvalidRatingException extends Exception {
    public InvalidRatingException(String message){
        super(message);
    }

}
