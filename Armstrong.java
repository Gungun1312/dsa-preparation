// Java program to check if a number is Armstrong
// using command line arguments

public class Armstrong {

    // Function to calculate x raised to the power y
    public static int power(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }

    // Function to calculate number of digits
    public static int order(int x) {
        int n = 0;
        while (x != 0) {
            n++;
            x /= 10;
        }
        return n;
    }

    // Function to check if a number is Armstrong
    public static boolean isArmstrong(int x) {
        int n = order(x);
        int sum = 0, temp = x;

        while (temp != 0) {
            int digit = temp % 10;
            sum += power(digit, n);
            temp /= 10;
        }

        return sum == x;
    }

    // Main method using command-line argument
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No command-line argument found.");
            return;
        }

        try {
            int num = Integer.parseInt(args[0]);

            if (isArmstrong(num)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }
}
