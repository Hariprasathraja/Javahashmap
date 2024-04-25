import com.google.gson.Gson;
import java.io.*;
import java.util.*;

public class UserDataManager {
    private static final String JSON_FILE_PATH = "D:\\Programs\\Javahashmap\\JavaHashmap\\src\\UserData.json";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, String> userData = load();
        if (userData == null) {
            userData = new HashMap<>();
        }
        System.out.print("Enter number of users: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter username:");
            String username = scanner.nextLine();
            System.out.println("Enter email:");
            String email = scanner.nextLine();
            userData.put(username, email);
        }
        save(userData);
        System.out.println("Data saved successfully!");
    }

    private static Map<String, String> load() {
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

    private static void save(Map<String, String> userData) {
        try (Writer writer = new FileWriter(JSON_FILE_PATH)) {
            Gson gson = new Gson();
            gson.toJson(userData, writer);
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }
}
