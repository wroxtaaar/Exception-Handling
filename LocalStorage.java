
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;

public class LocalStorage {

    public String getPassword(String username) {
        Map<String, String> unameToPassMap = new HashMap<>();

        unameToPassMap = getUsernameToPasswordMapping();

        String password = unameToPassMap.get(username);

        return password;
    }

  

    public Map<String, String> getUsernameToPasswordMapping() {
        // read login data from file
        File loginDataFile = new File("resources/UnameToPass.txt");
        FileReader fileReader = new FileReader(loginDataFile); 
        BufferedReader bufferedReader = new BufferedReader(fileReader); 
        System.out.println("Opened resource");

        String inputLine, userName, password;
        Map<String, String> unameToPassMap = new HashMap<String, String>();
        
        // map each username password pair
        while ((inputLine = bufferedReader.readLine()) != null)
        {
            userName = inputLine.split(":")[0];
            password = inputLine.split(":")[1];
            unameToPassMap.put(userName, password);
        }

        bufferedReader.close();
        fileReader.close();
        System.out.println("Closed resource");

        return unameToPassMap;
    }
}




  // public Map<String, String> getUsernameToPasswordMapping() {
    // File loginJson = new
    // File("src/main/java/com/example/exception/UnameToPass.txt");

    // ObjectMapper objectMapper = new ObjectMapper();

    // Map<String, String> unameToPassMap = objectMapper.readValue(loginJson, new
    // TypeReference<Map<String,String>>() {});

    // return unameToPassMap;
    // }


// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Map;
// import java.util.Scanner;

// import java.util.HashMap;

// public class LocalStorage {

//     public String getPassword(String username) {
//         Map<String, String> unameToPassMap = new HashMap<>();

//         unameToPassMap = getUsernameToPasswordMapping();

//         String password = unameToPassMap.get(username);

//         return password;
//     }

//     public Map<String, String> getUsernameToPasswordMapping() {
//         File loginDataFile = new File("src/main/resources/UnameToPass.txt");
        
//         Scanner scanner = new Scanner(loginDataFile);
//         System.out.println("Opened scanner");

//         Map<String, String> unameToPassMap = new HashMap<>();

//         while (scanner.hasNextLine()) {
//             String line = scanner.nextLine().trim();
//             String uname = line.split(":")[0];
//             String pass = line.split(":")[1];

//             unameToPassMap.put(uname, pass);
//         }
        
//         scanner.close();
//         System.out.println("Closed scanner");

//         return unameToPassMap;
//     }
// }

