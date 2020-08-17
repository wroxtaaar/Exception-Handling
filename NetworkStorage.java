
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;

public class NetworkStorage {
    public String getPassword(String username) throws IOException {
        Map<String, String> unameToPassMap = new HashMap<>();

        unameToPassMap = getUsernameToPasswordMapping();

        String password = unameToPassMap.get(username);

        return password;
    }

    public Map<String, String> getUsernameToPasswordMapping() throws IOException {
        URL file = new URL(
                "https://gitlab.crio.do/crio_bytes/jackson/-/raw/master/src/main/java/com/example/jackson/trades.json");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.openStream()));
        System.out.println("Opened resource");

        Map<String, String> unameToPassMap = new HashMap<String, String>();

        StringBuilder stringBuilder = new StringBuilder();

        String inputLine, userName, password;
        while ((inputLine = bufferedReader.readLine()) != null) {
            userName = inputLine.split(":")[0];
            password = inputLine.split(":")[1];
            unameToPassMap.put(userName, password);
        }

        bufferedReader.close();
        System.out.println("Closed resource");

        return unameToPassMap;
    }
}