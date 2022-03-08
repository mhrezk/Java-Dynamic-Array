import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Class to create a Dynamic Array
 *
 * @author Mohamed Rezk
 * @see Main
 * @version 1.8
 */
public class Numbers {
    /**
     * Stores float values.
     */
    private float [] array;//instance variable for array

    /**
     * Store the number of items currently in the array.
     */
    private int size = 0;//instance variable for array size

    /**
     * Store the total capacity within the array.
     */
    int capacity = 10;//instance variable for array capacity

    /**
     * Default Constructor
     */
    public Numbers() {//non-parameterized constructor accepts capacity variable as array size
        this.array = new float[capacity];
    }

    /**
     * Constructor that initializes the numbers array.
     * @param size - Max size of the numbers array
     */
    public Numbers(int size) {//parameterized constructor accepts parameter as array size
        this.array = new float[size];
    }

    /**
     * Getter method for size field
     * @return size as an integer
     */
    public int getSize() {
        return size;
    }

    /**
     * Getter method for index of array
     * @param index of element being retrieved
     * @return index of element as an integer
     */
    public float get(int index) {
        return array[index];
    }

    /**
     * Adds a value in the array
     * @param input - Scanner object to use for input
     */
    public void insertValue(Scanner input) {
        if (array.length == size){//displays message if the length of array is equal to entered size
            System.out.println("Array is full!");
        } else if (size >= capacity) {//grows the static array into dynamic array
            grow();
        } else {
            System.out.print("Enter value: ");//accepts user input for individual elements of array
            if (input.hasNextFloat()) {
                array[size] = input.nextFloat();
                System.out.println("Element has been added!");//alerts user with addition
            }
            else{
                throw new InputMismatchException();//detects string input
            }
            size++;//increases size of array for dynamic expansion if needed
            input.nextLine();//clears input buffer
        }
    }

    /**
     * Method that expands an array dynamically
     */
    private void grow() {

        int newCapacity = capacity * 2;//creates new capacity
        float[] newArray = new float[newCapacity];

        if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);//copies old array into new array to create a dynamic array
        capacity = newCapacity;
        array = newArray;

        //Manual Array Copy
//        for(int i = 0; i < size; i++) {
//            newArray[i] = array[i];
//        }
//        capacity = newCapacity;
//        array = newArray;
    }

    /**
     * Method to check and see if array is empty
     * @return boolean value to indicate if array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Calculates the average of all the values in the numbers array.
     * @return float value that represents the average
     */
    public float calcAverage() {
        float sum = 0;

        // sum of all values in array using for loop
        for (float n : array) {
            sum += n;
        }

        if(size == 0) {
            return 0;
        }

        return sum / size;
    }

    /**
     * {@inheritDoc}
     * Overridden toString method that displays array elements
     * @return formatted string for array display
     */
    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        for(int i = 0; i < size; i++) {
            string.append(array[i]).append(", ");
        }
        if(!string.toString().equals("")) {
            string = new StringBuilder("[" + string.substring(0, string.length() - 2) + "]");
        }
        else {
            string = new StringBuilder("[]");
        }
        return string.toString();
    }

    /**
     * Calculates the maximum and minimum values of elements within array
     * @return string value that represents calculated maximum and minimum values
     */
    public String valuesMaxMin() {

        float max = array[0];
        float min = array[0];

        // iterate and compare from array index 1
        for(int i = 1; i < size; i++){
            if(max < array[i]){
                max = array[i];
            }else if(min > array[i]){
                min = array[i];
            }
        }
        return " Maximum Value: " + max + " Minimum Value: " + min; //displays maximum and minimum values
    }

    /**
     * Method to test for empty user inputs
     * @param input Scanner object to use for input
     * @return string value entered by user
     * @throws IllegalAccessException Indicates user input is empty
     */
    public String emptyString(Scanner input) throws IllegalAccessException {
        String user = input.nextLine();
        if (user.isEmpty()) {
            throw new IllegalAccessException();
        }
        return user;
    }
}//end of Numbers class

