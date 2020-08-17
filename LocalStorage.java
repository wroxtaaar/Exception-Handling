
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;

public class LocalStorage {

    public String getPassword(String username) throws FileNotFoundException {
        Map<String, String> unameToPassMap = new HashMap<>();

        unameToPassMap = getUsernameToPasswordMapping();

        String password = unameToPassMap.get(username);

        return password;
    }

    public Map<String, String> getUsernameToPasswordMapping() throws FileNotFoundException {
        File loginDataFile = new File("src/main/resources/UnameToPass.txt");
        
        Scanner scanner = new Scanner(loginDataFile);
        System.out.println("Opened scanner");

        Map<String, String> unameToPassMap = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            String uname = line.split(":")[0];
            String pass = line.split(":")[1];

            unameToPassMap.put(uname, pass);
        }
        
        scanner.close();
        System.out.println("Closed scanner");

        return unameToPassMap;
    }
}














// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.Map;
// import java.util.Scanner;

// import java.util.HashMap;

// public class LocalStorage implements Storage {

//     public String getPassword(String username) {
//         Map<String, String> unameToPassMap = new HashMap<>();

//         unameToPassMap = getUsernameToPasswordMapping();

//         String password = unameToPassMap.get(username);

//         return password;
//     }

//     // public Map<String, String> getUsernameToPasswordMapping() {
//     // File loginJson = new
//     // File("src/main/java/com/example/exception/UnameToPass.txt");

//     // ObjectMapper objectMapper = new ObjectMapper();

//     // Map<String, String> unameToPassMap = objectMapper.readValue(loginJson, new
//     // TypeReference<Map<String,String>>() {});

//     // return unameToPassMap;
//     // }

//     public Map<String, String> getUsernameToPasswordMapping() {
//         File loginDataFile = new File("src/main/resources/UnameToPass.txt");

//         Map<String, String> unameToPassMap = new HashMap<String, String>();

//         FileReader fileReader = new FileReader(loginDataFile); // reads the file
//         BufferedReader bufferedReader = new BufferedReader(fileReader); // creates a buffering character input stream

//         StringBuilder stringBuilder = new StringBuilder();

//         String inputLine, userName, password;
//         while ((inputLine = bufferedReader.readLine()) != null)
//         {
//          userName = inputLine.split(":")[0];
//          password = inputLine.split(":")[1];
//          unameToPassMap.put(userName, password);
//         }

//         bufferedReader.close();
               
//         return unameToPassMap;
//     }
// }