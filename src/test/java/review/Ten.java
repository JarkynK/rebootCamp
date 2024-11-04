package review;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ten {

    public static void main(String[] args) {
        Map<String, String> passwords = new HashMap<>();

        // put
        passwords.put("eniiazov", "Cybertek123");
        passwords.put("eniiazov1", "test123");
        System.out.println(passwords.size());

        // get
        System.out.println(passwords.get("eniiazov"));

        // remove
        //System.out.println(passwords.remove("eniiazov"));
        System.out.println(passwords.get("eniiazov"));

        // keySet
        Set<String> keys = passwords.keySet();
        System.out.println();
        for(String key: keys){
            System.out.println(passwords.get(key));
        }

    }
}
