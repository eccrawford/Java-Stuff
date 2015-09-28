import java.util.*;
public class rev {
    public static Map<Integer, String> reversePhoneBook(Map<String, Integer> phoneBook) {
        Map<Integer, String> rev = new TreeMap<Integer, String>();
        String newVal;
        for (Map.Entry<String, Integer> entry :  phoneBook.entrySet()) {
            String newValues = entry.getKey();
            if (!rev.containsKey(entry.getValue())) { 
                rev.put(entry.getValue(), entry.getKey());
            }
            else {
                newVal = rev.get(entry.getValue()) + " & " + newValues;
                rev.put(entry.getValue(), newVal);
            }
        }
        return rev;
    }
}