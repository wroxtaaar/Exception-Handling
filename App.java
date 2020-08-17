
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    LocalStorage localStorage = new LocalStorage();
    NetworkStorage networkStorage = new NetworkStorage();

    public String loginOffline(String username, String inputPassword) {
        String expectedPassword = localStorage.getPassword(username);

        if (expectedPassword.equals(inputPassword)) {
            return "Login successful";
        } else {
            return "Invalid password!";
        }
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.loginOffline("Dhoni", "dhoni"));
        // System.out.println(new App().loginOnline("Dhoni", "dhoni"));
    }


    public String loginOnline(String username, String password) {
        try {
            String expected = networkStorage.getPassword(username);

            if (expected == null) {
                return "No record of user";
            }
            else if (expected.equals(password)) {
                return "Login successful";
            } else {
                return "Invalid password!";
            }

        } catch (IOException e) {
            // log error trace to file
            e.printStackTrace();
            return "Internal error, please try again later";
        }
    }

    // public void login(String username, String password) {
    //     String expected = secStorage.getPassword(username);
    //     if (expected == null) {
    //         expected = netStorage.getPassword(username);
    //     }
    //     System.out.println(expected);

    //     if (expected == null) {
    //         System.out.println("Internal issue");
    //     }
    //     else if (!expected.equals(password)) {
    //         System.out.println("Invalid username/password!");
    //     } else {
    //         System.out.println("Login successful");
    //     }

    // }

}