import java.util.*;
import java.io.*;

public class UserDataManager {
    private static final String JSON_FILE_PATH = "D:\\Programs\\Javahashmap\\UserData.json";
    private static final Scanner s= new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, String> userData=load();
        if (userData == null) {
            userData = new HashMap<>();
        }
        System.out.print("Enter no of users: ");
        int n=s.nextInt();
        s.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Enter username:");
            String username = s.nextLine();
            System.out.println("Enter email:");
            String email = s.nextLine();
            userData.put(username, email);
        }
            save(userData);
        System.out.println("Data saved successfully!");
    }

    private static Map<String, String> load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(JSON_FILE_PATH))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            if (json.length() > 0) {
                return parseJSON(json.toString());
            } else {
                System.out.println("JSON file is empty. Creating a new one.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("JSON file not found. Creating a new one.");
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
        return new HashMap<>();
    }
    private static void save(Map<String, String> userData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_FILE_PATH))) {
            writer.write(toJSON(userData));
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }

    private static String toJSON(Map<String, String> userData) {
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : userData.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\",");
        }
        if (json.charAt(json.length() - 1) == ',') {
            json.deleteCharAt(json.length() - 1);
        }
        json.append("}");
        return json.toString();
    }

    private static Map<String, String> parseJSON(String json) {
        Map<String, String> userData = new HashMap<>();
        String[] pairs = json.substring(1, json.length() - 1).split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim().substring(1, keyValue[0].length() - 1);
            String value = keyValue[1].trim().substring(1, keyValue[1].length() - 1);
            userData.put(key, value);
        }
        return userData;
    }
}
