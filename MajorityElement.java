import java.util.*;
import java.io.*;
public class MajorityElement {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        HashMap<Integer , Integer> map = new HashMap<>();

        for (int i =0 ; i<n ; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i] , map.get(arr[i]) + 1);
            }else{
                map.put(arr[i] , 1);
            }
        }

        for(Integer key : map.keySet()){
            if(map.get(key) > arr.length/3){
                System.out.println(key);
            }
        }
    }
}