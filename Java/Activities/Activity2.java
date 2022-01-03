package activities;

import java.util.Arrays;

public class Activity2 {

	public static void main(String[] args) {
		int[] numArr = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(numArr));
        
        //Set constants
        int searchNum = 10;
        int fixedsum = 30;
        int temp = 0;
        for (int number : numArr) {
            
            if (number == searchNum) {
                
                temp += searchNum;
            }
            
        }
        if (temp == fixedsum) {
        	System.out.println("Result: True" );
        	
        } else {
        	System.out.println("Result: False" );
        }
	}

}
