import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

class UserDetails {
    private String name;
    private String address;
    private String dob;
    private String email;
    private String accountType;
    private double accountSavings;

    public UserDetails(String name, String address, String dob, String email, String accountType, double accountSavings) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.accountType = accountType;
        this.accountSavings = accountSavings;
    }
    
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getDob() {
        return dob;
    }
    public String getEmail() {
        return email;
    }
    public String getAccountType() {
        return accountType;
    }
    public double getAccountSavings() {
        return accountSavings;
    }
}

public class UserDataManager {
    private static final String JSON_FILE_PATH = "D:\\Programs\\Javahashmap\\JavaHashmap\\src\\UserData.json";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Integer, UserDetails> userData = load();
        if (userData == null) {
            userData = new HashMap<>();
        }
        System.out.print("Enter number of users: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter account number:");
            int accountNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter address:");
            String address = scanner.nextLine();
            System.out.println("Enter date of birth:");
            String dob = scanner.nextLine();
            System.out.println("Enter email:");
            String email = scanner.nextLine();
            System.out.println("Enter account type:");
            String accountType = scanner.nextLine();
            System.out.println("Enter account savings:");
            double accountSavings = scanner.nextDouble();
            scanner.nextLine();
            
            UserDetails userDetails = new UserDetails(name, address, dob, email, accountType, accountSavings);
            userData.put(accountNumber, userDetails);
        }
        save(userData);
        System.out.println("Data saved successfully!");
    }

    private static Map<Integer, UserDetails> load() {
        try (Reader reader = new FileReader(JSON_FILE_PATH)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, HashMap.class);
        } catch (FileNotFoundException e) {
            System.out.println("JSON file not found. Creating a new one.");
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
        return null;
    }

    private static void save(Map<Integer, UserDetails> userData) {
    try (Writer writer = new FileWriter(JSON_FILE_PATH)) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Enable pretty printing
        String newline = System.getProperty("line.separator"); // Get the system's newline character
        gson.toJson(userData, writer);
        writer.write(newline); // Add a newline character after writing the JSON data
    } catch (IOException e) {
        System.out.println("Error writing JSON file: " + e.getMessage());
    }
}

}
