// ********************************************
// CustomerRating.java
// Claire Jane  T00783917
// COMP 1231 – Assignment 3:
// This  program reads customer survey data from a file,
// allows users to enter additional records, handles
// input and array exceptions, and writes the updated
// list and averages back to the file.
// ********************************************


import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerRating {
    static Customer[] customers = new Customer[5];
    static int customerCount = 0;
    
    public static void main(String[] args){
        Scanner scan = null;
    //Reads existing customers and ratings from the file and populates the array.
        try {
           scan = new Scanner(new File("rating.txt")); 
           while (scan.hasNextInt()){
            int age = scan.nextInt();
            double rating = scan.nextDouble();
            customers[customerCount] = new Customer(age, rating);
            customerCount++;
           }
           scan.close();
        } catch (IOException e) {
            System.out.println("Error while reading from file. Terminating application now.");
            System.exit(1); 
        }
        //Display existing customers
        printCustomerList(customers, customerCount);
        //Prompt user for new customers until they enter '!'
        while (true) {
            System.out.print("Enter age[integer], followed by ONE [TAB] key , then rating[decimal number] (or type '!' to exit): ");
            scan = new Scanner(System.in);
            String input = scan.nextLine();
        //Checks if user wishes to terminate the application
            if (input.equals("!")){
                break;
            }
        //Splits the input into two parts using the tab as a regex, if not 2 part input it repeats the loop
            String[] parts = input.split("\t");
            if (parts.length != 2){
                continue;
            }
        //Tries to store input in array, handling if it is an invalid number or when the array is full
            try {
                int age = Integer.parseInt(parts[0]);
                double rating = Double.parseDouble(parts[1]);    
                customers[customerCount] = new Customer(age, rating);
                customerCount++;
                System.out.printf("Customer added: Age = %d\tRating = %.2f\n", age, rating);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array Out of Bound!! Record skipped");
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number! Record skipped");
            }
            
            
        }
        scan.close();
        //After closing the scanner, tries writing to the file, handling IO exceptions and overwriting all original Customers with the array population (including the originals)
        try {
            PrintWriter writer = new PrintWriter("rating.txt");

            for(int x = 0; x > customerCount; x++){
                writer.write(customers[x].getAge() + "\t" + customers[x].getRating());
            }
            writer.close();
        }catch (IOException e){
            System.out.println("Error while writing to file. Terminating application now.");
            System.exit(1);
        }
        //Calculates and displays average age and rating, prints customer list, and terminates the application. 
        //This and the writing to the file only occur when the user breaks the loop with '!'
            double averageAge = 0;
            double averageRating = 0;
            for (int x = 0; x < customerCount; x++){
                averageAge += customers[x].getAge();
                averageRating += customers[x].getRating();
            } 
            averageAge = averageAge/customerCount;
            averageRating = averageRating/customerCount;
            System.out.println("\n");
            printCustomerList(customers, customerCount);
            System.out.printf("Average(Age)=%.2f\n",averageAge);
            System.out.printf("Average(Rating)=%.2f",averageRating);
            System.exit(1);
    }
private static void printCustomerList(Customer[] customers, int customerCount){
    System.out.println("Most updated list of customer ratings");
    System.out.println("----------------------------------------");
    System.out.println("    Age                      Rating     ");
    System.out.println("----------------------------------------");
    for(int x = 0; x < customerCount; x++){
            System.out.printf("%6d%28.2f\n", customers[x].getAge(), customers[x].getRating());
    }
        
    System.out.println("----------------------------------------");
    }
   
}
