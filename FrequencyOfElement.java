import java.util.*;
import java.io.*;
    public class FrequencyOfElement{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read size of array

        int n = Integer.parseInt(br.readLine());
        
        //Read elements of array taken as a single line of space-separated integers

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        
        Map<Integer , Integer> freqMap = new LinkedHashMap<>();
        
        // Count frequency of each element in the array
        for (int num:arr){
            freqMap.put(num , freqMap.getOrDefault(num , 0)+1);
        }

        //output in required format

        for(Map.Entry<Integer , Integer> entry : freqMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}