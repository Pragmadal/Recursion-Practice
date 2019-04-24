import java.util.Scanner;

public class sak66330_a16 {
    static int callCount1 = 0, callCount2 = 0;
    static int[][] array;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        array = new int[n+1][k+1];
        System.out.println(coefficients(n, k) + " " + callCount1);
        System.out.println(coefficients2(n, k) + " " + callCount2);
        printArray(array);
    }

    public static int coefficients2(int n, int k) {
        callCount2++;
        if (array[n][k] != 0) return array[n][k];
        else if (n == k || k == 0) {
            array[n][k] = 1;
            return 1;
        }
        else {
            array[n][k] = coefficients2(n - 1, k) + coefficients2(n - 1, k - 1);
            return array[n][k];
        }
    }

    public static int coefficients(int n, int k) {
        callCount1++;
        if (n == k || k == 0) return 1;
        else return coefficients(n - 1, k) + coefficients(n - 1, k - 1);
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                if (array[i][j] != 0) {
                    System.out.print(i + " " + j + " " + array[i][j] + "\n");
                }
        }
    }
}
