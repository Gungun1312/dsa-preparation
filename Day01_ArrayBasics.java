import java.util.Scanner;

public class Day01_ArrayBasics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Declare and initialize array
        int[] arr = new int[n];

        // Input elements
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Display elements
        System.out.print("Array elements are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Calculate sum, max, and min
        int sum = 0, max = arr[0], min = arr[0];
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        System.out.println("Sum of elements: " + sum);
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);

        sc.close();
    }
}
