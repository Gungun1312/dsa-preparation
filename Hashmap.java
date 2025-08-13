import java.util.HashMap;
import java.util.Set;
public class Hashmap{
    public static void main(String args[]){
        //create a ahshmap
        HashMap<String , Integer> map = new HashMap<>();

        //insert elements into the hashmap
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);
        map.put("apple", 4); // This will update the value for "apple"

        System.out.println(map);

        //retrieve elements from the hashmap
        System.out.println("Value for 'apple': " + map.get("apple")); // Output: 4
        System.out.println("Value for 'banana': " + map.get("banana")); // Output
        System.out.println("Value for 'orange': " + map.get("orange")); // Output: 3

        Set<String> keys = map.keySet();
        System.out.println(keys);

        // Iterate through the keys and print key-value pairs
        for (String k : keys){
            System.out.println("Key: " + k + ", Value: " + map.get(k));
        }

    }
}