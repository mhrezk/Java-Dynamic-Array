//Import Statements
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Driver class to test dynamic arrays
 * @author Mohamed Rezk
 * @see Numbers
 * @version 1.8
 */
public class Main {

    /**
     * Method to display menu for user choice
     * @param input Scanner object to use for input
     * @return user input as integer
     * @throws IllegalAccessException Indicates user input is empty
     * @throws NumberFormatException Indicates user input is empty
     */
    public static int displayMainMenu(Scanner input) throws IllegalAccessException, NumberFormatException {
        int option;
        System.out.println("Welcome! What would you like to do?");
        System.out.println("1) Initialize a default array\n" +
                "2) Specify maximum size of array\n" +
                "3) Add a value to array\n" +
                "4) Display array\n" +
                "5) Display average, maximum and minimum values within array\n" +
                "6) Exit program\n");
        System.out.print("Choose an option: ");
        String truth = input.nextLine();
        if(truth.isBlank()) {
            throw new NumberFormatException();
        } else if(truth.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            option = Integer.parseInt(truth);//string is parsed to integer and returned
        }
        return option;
    }


    /**
     * Main method to test Numbers class
     * @param args Variable to store command line prompt
     */
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner input = new Scanner(System.in);
        int option = 0;
        Numbers n = new Numbers();

        do {//beginning of do-while loop
            try {//beginning of try-catch block

                //returned integer from displayMainMenu() method is assigned to option variable
                switch (option = displayMainMenu(input)) {//beginning of switch
                    case 1:
                        n = new Numbers();//array is instantiated with a capacity of 10
                        System.out.println("New array created!");//array creation alert
                        break;
                    case 2:
                        System.out.print("Enter desired size of array: ");
                        int size = Integer.parseInt(n.emptyString(input));//returned string is parsed into integer
                        n = new Numbers(size);//user input assigned as size of array
                        System.out.println("Array of size " + size + " has been created!");//alert message
                        break;
                    case 3:
                        n.insertValue(input);//addition of elements into array
                        break;
                    case 4:
                        if(n.isEmpty()) {//if array is empty, message is displayed
                            System.err.println("Array is empty!");
                        }
                        System.out.println("Values are => " + n);//displays array elements via toString()
                        break;
                    case 5:
                        System.out.println("Average: " + n.calcAverage() +
                                n.valuesMaxMin() + "\n");//displays average, maximum and minimum values
                        break;
                    case 6:
                        System.out.println("Thank you for using Algonquin Array Creator!");//exit message
                        break;
                    default://default message is displayed if user input is mismatched
                        System.err.println("Invalid Input! Please retry!");
                }//end of switch
            } catch (InputMismatchException e) {//catches InputMismatchException
                System.err.println("Incorrect entry! Please choose from options above!");
                input.nextLine();
            } catch (IllegalAccessException | NumberFormatException e) {//catches IllegalAccessException or NumberFormatException
                System.err.println("A number must be entered! Please retry!");
            } //end of try-catch
        } while (option != 6);//end of do-while loop; condition is set for looping
    }//end of main method
}//end of driver class