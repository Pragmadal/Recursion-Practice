import java.util.Scanner; // Importing the Scanner class for user inputs
import java.math.BigInteger;

public class sak66330_a16 { // Main class
    static int callCount1 = -1, callCount2 = -1; // Class variables to count the number of recursive calls in related methods, they start at -1 to counter the initial call.

    public static void main(String[] args) { // Main method
        Scanner input = new Scanner(System.in); // 'input' instance to take in user inputs

	System.out.print("Enter two whole numbers 'n' and 'k' to calculate their binomial coefficient \n--> n k\n--> ");
        int n = input.nextInt(), k = input.nextInt(); // Inputs used to find the values for 'n' and 'k'
	int[][] array; // An int[] array used for method coefficients3(), which retains any value that is discovered through the recusion for later use

	while (n < 0 || k < 0) { // In case the user is bad at reading directions
		System.out.print("\nWhole numbers can not be negative, believe it or not. Try again\n--> n k\n--> ");	
		n = input.nextInt(); k = input.nextInt();	
	}

        array = new int[n+1][k+1]; // Assign the array lengths depending on the user inputs, they are +1 to counter the effect of the indexes starting at 0
	
	System.out.print("-_-_-_-_-_-_-_-_-_-_-| Binomial-Coefficient | Recursive Calls\n" + // Fancy print-out for the values and call numbers
			 "With Loops           | " + coefficients1(n, k) + " | 0\n" +
			 "With Recursion       | " + coefficients2(n, k) + " | " + callCount1 + "\n" +
			 "With Recursion/Array | " + coefficients3(n, k, array) + " | " + callCount2 + "\n" +
			 "-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
    }

    public static BigInteger coefficients1(int n, int k) { // First method which uses loops
	BigInteger numer = BigInteger.valueOf(n), denom1 = BigInteger.valueOf(k), denom2 = BigInteger.valueOf(n - k); // Objects used for the final calculation, each represent a different factorial calculation
	for (int i = 0; i < n; i++) // A loop to calculate the factorial of n
		if (i > 0) numer = numer.multiply(BigInteger.valueOf(n - i)); // The value gets multiplied by a number incrementally less than n	

	for (int i = 0; i < k; i++) // A loop to calculate the factorial of k
		if (i > 0) denom1 = denom1.multiply(BigInteger.valueOf(k - i)); // On other loops the value gets multiplied by a number incrementally less than k	

	for (int i = 0; i < n - k; i++) // A loop to calculate the factorial of (n - k)
		if (i > 0) denom2 = denom2.multiply(BigInteger.valueOf(n - k - i)); // On other loops the value gets multiplied by a number incrementally less than (n - k)
	
	if (n == k || k == 0) return BigInteger.ONE; // The coefficient will be 1 if either of those conditions are met
	else if (n < k) return BigInteger.ZERO; // If n is less than k then the coefficient is 0
	else return numer.divide(denom1.multiply(denom2)); //numer / (denom1 * denom2); // Otherwise, this calculation finds the coefficient
    }
    
     public static int coefficients2(int n, int k) { // Second method which uses pure recursion
        callCount1++; // Counts the number of recursive calls

        if (n == k || k == 0) return 1; // If end conditions are met, a 1 is returned
	else if (n < k) return 0; // If n is less than k, no recursion is done and a 0 is returned
        else return coefficients2(n - 1, k) + coefficients2(n - 1, k - 1); // If no end conditions are yet met then this formula will be implemented until they are
    }

    public static int coefficients3(int n, int k, int[][] array) { // Third method which uses recursion with a value-holding, multi-dimensional array to limit the number of recursive calls
        callCount2++; // Counts the number of recursive calls

        if (array[n][k] != 0) return array[n][k];
        else if (n == k || k == 0) { // If end conditions are met
            array[n][k] = 1; // 1 is assigned to the relevant element

            return 1; // 1 is returned
        }
	else if (n < k) return 0; // If n is less than k, no recursion is done and a 0 is returned
        else { // If no end conditions are met
            array[n][k] = coefficients3(n - 1, k, array) + coefficients3(n - 1, k - 1, array); // Assign the recursive calculation value to the relevant element

            return array[n][k]; // Return the value found
        }
    }

    public static void printArray(int[][] array) { // This was used to test if the array was functioning in the intended way, it has no intended purpose for the user
        for (int i = 0; i < array.length; i++) { // For every row
            for (int j = 0; j < array[i].length; j++) // For every column
                if (array[i][j] != 0) System.out.print(i + " " + j + " " + array[i][j] + "\n"); // Prints elements that are assigned values during the recursion
        }
    }
}


