import proto.UserDetailsOuterClass;
import java.io.*;
import java.util.*;

public class UserDataManager {
    private static final String PROTO_FILE_PATH = "D:\\Programs\\Javahashmap\\JavaHashmap\\src\\UserData.proto";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Integer, UserDetailsOuterClass.UserDetails> userData = load();
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
            
            UserDetailsOuterClass.UserDetails userDetails = UserDetailsOuterClass.UserDetails.newBuilder()
                .setName(name)
                .setAddress(address)
                .setDob(dob)
                .setEmail(email)
                .setAccountType(accountType)
                .setAccountSavings(accountSavings)
                .build();
                
            userData.put(accountNumber, userDetails);
        }
        save(userData);
        System.out.println("Data saved successfully!");
    }

    private static Map<Integer, UserDetailsOuterClass.UserDetails> load() {
        try (FileInputStream fis = new FileInputStream(PROTO_FILE_PATH)) {
            return UserDetailsOuterClass.UserDetails.parseFrom(fis).getUserDataMap();
        } catch (IOException e) {
            System.out.println("Error reading protobuf file: " + e.getMessage());
        }
        return null;
    }

    private static void save(Map<Integer, UserDetailsOuterClass.UserDetails> userData) {
        try (FileOutputStream fos = new FileOutputStream(PROTO_FILE_PATH)) {
            UserDetailsOuterClass.UserDetails.newBuilder()
                .putAllUserData(userData)
                .build()
                .writeTo(fos);
        } catch (IOException e) {
            System.out.println("Error writing protobuf file: " + e.getMessage());
        }
    }
}
