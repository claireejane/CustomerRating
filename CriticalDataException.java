// ********************************************
// CriticalDataException.java
// Claire Jane  T00783917
// COMP 1231 – Assignment 3:
// This  class defines a custom exception used to signal
// critical file I/O errors during reading or writing.
// ********************************************

public class CriticalDataException extends RuntimeException {
    public CriticalDataException(String message){
        super(message);
    }
    
}

