// package com.example.exception;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Map;
// import java.util.Scanner;

// import java.util.HashMap;

// public class TextStorage {
//     // private static final int HashMap = 0;

//     // public String getData(String url) {
//     // // wrong url - propogate to client code

//     // }

//     public String getPassword(String username) throws FileNotFoundException {
//         Map<String, String> unameToPassMap = new HashMap<>();

//         unameToPassMap = getUsernameToPasswordMapping();

//         String password = unameToPassMap.get(username);

//         return password;
//     }

//     public Map<String, String> getUsernameToPasswordMapping() throws FileNotFoundException {
//         File loginJson = new File("src/main/java/com/example/jackson/UnameToPass.txt");
        
//         // TODO: has to try-catch here else, won't close sc resource
//         Scanner sc = new Scanner(loginJson);
//         System.out.println("Opened scanner");

//         Map<String, String> unameToPassMap = new HashMap<>();

//         while (sc.hasNextLine()) {
//             String line = sc.nextLine().trim();
//             String uname = line.split(":")[0];
//             String pass = line.split(":")[1];

//             unameToPassMap.put(uname, pass);
//         }
        
//         sc.close();
//         System.out.println("Closed scanner");

//         return unameToPassMap;
//     }
// }