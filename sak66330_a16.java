import java.util.Scanner;

public class sak66330_a16 {
    static int callCount1 = 0, callCount2 = 0;
    static int[][] array;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        array = new int[n+1][k+1];
        System.out.println(coefficients1(n, k));
        System.out.println(coefficients2(n, k) + " " + callCount1);
        System.out.println(coefficients3(n, k) + " " + callCount2);
        printArray(array);
    }

    public static int coefficients1(int n, int k) {
		int numer = 0, denom1 = 0, denom2 = 0;
		for (int i = 0; i < n; i++) {
			if (i == 0)
				numer = n; denom1 = k; denom2 = n - k;
			if (i > 0) numer *= n - i;
		}	
		for (int i = 0; i < k; i++) {
			if (i == 0)
				denom1 = k;
			if (i > 0) denom1 *= k - i;
		}	
		for (int i = 0; i < n - k; i++) {
			if (i == 0)
				denom2 = n - k;
			if (i > 0) denom2 *= n - k - i;
		}	
		return numer / (denom1 * denom2);
	}
    
     public static int coefficients2(int n, int k) {
        callCount1++;
        if (n == k || k == 0) return 1;
        else return coefficients2(n - 1, k) + coefficients2(n - 1, k - 1);
    }
    
    public static int coefficients3(int n, int k) {
        callCount2++;
        if (array[n][k] != 0) return array[n][k];
        else if (n == k || k == 0) {
            array[n][k] = 1;
            return 1;
        }
        else {
            array[n][k] = coefficients3(n - 1, k) + coefficients3(n - 1, k - 1);
            return array[n][k];
        }
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                if (array[i][j] != 0) System.out.print(i + " " + j + " " + array[i][j] + "\n");
        }
    }
}
