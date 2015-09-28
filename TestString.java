import java.util.Scanner;

public class TestString {
    static int count = 0;
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        final String USERNAME = "student";
        final String PASSWORD = "lovetolearn";
        String username = "";
        String password = "";

        System.out.println("Welcome to the career explorer program. \nPlease enter your username and password.");
        System.out.println("Username (must be between 6 and 12 characters long): ");
        username = userInput.next();
        System.out.println("Password (must be between 6 and 12 characters long): ");
        password = userInput.next();
        while (count <= 3) {
            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                System.out.println("Welcome " + USERNAME + ", to the career explorer software!");
                break;
            }
            else if (username.length() < 6 || username.length() > 12 || password.length() < 6 ||
            password.length() > 12 ) {
                System.out.println("Sorry, either your username or password was not between 6 & 12 characters.");
                count += 1;
                
                if (count == 3) {
                    System.out.println("Sorry, you have been locked out.");
                    System.exit(0);
                }
                System.out.println("Username (must be between 6 and 12 characters long): ");
                username = userInput.next();
                System.out.println("Password (must be between 6 and 12 characters long): ");
                password = userInput.next();

            }
            else if (!username.equals(USERNAME) || !password.equals(PASSWORD) && username.length() >= 6 &&
            username.length() < 12 && password.length() >= 6 && password.length() < 12) {
                System.out.println("Sorry, either your username or password was not correct");
                count += 1;
               
                if (count == 3) {
                    System.out.println("Sorry, you have been locked out.");
                    System.exit(0);
                }
                System.out.println("Username (must be between 6 and 12 characters long): ");
                username = userInput.next();
                System.out.println("Password (must be between 6 and 12 characters long): ");
                password = userInput.next();
            }
        }
    }

}