import java.io.*;

public class ReverseArray {
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        
        // Read one line of space-separated integers
        String[] input = br.readLine().split(" ");
        
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        reverseArray(arr);

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
