package cbp;

import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * UserConsoleApp – Handles user registration, login, and BMI tracking.
 * Demonstrates Inheritance, Exception Handling, Collections, and JDBC.
 */
public class UserConsoleApp {
    protected Connection conn;
    private Scanner sc = new Scanner(System.in);
    private int currentUserId;
    private String currentUserName, currentGender, currentActivity;
    private int currentAge;
    private double currentHeight, currentWeight;

    // Constructor
    public UserConsoleApp(Connection conn) {
        this.conn = conn;
    }

    // Start user interface
    public void start() {
        while (true) {
            System.out.println("\n==== USER MENU ====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Exiting user menu.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // User registration
    private void register() {
        try {
            String email;
            while (true) {
                System.out.print("Email: ");
                email = sc.nextLine().trim();

                String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
                if (!Pattern.matches(emailRegex, email)) {
                    System.out.println("Invalid email format! Try again.");
                    continue;
                }

                PreparedStatement check = conn.prepareStatement("SELECT * FROM users WHERE email=?");
                check.setString(1, email);
                if (check.executeQuery().next()) {
                    System.out.println("Email already exists!");
                    continue;
                }
                break;
            }

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            String gender;
            while (true) {
                System.out.print("Gender (Male/Female): ");
                gender = sc.nextLine().trim();
                if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
                    gender = gender.substring(0, 1).toUpperCase() + gender.substring(1).toLowerCase();
                    break;
                }
                System.out.println("Invalid input!");
            }

            double height;
            while (true) {
                System.out.print("Height (m): ");
                height = sc.nextDouble();
                sc.nextLine();
                if (height >= 0.5 && height <= 2.5) break;
                System.out.println("Invalid height!");
            }

            double weight;
            while (true) {
                System.out.print("Weight (kg): ");
                weight = sc.nextDouble();
                sc.nextLine();
                if (weight >= 10 && weight <= 300) break;
                System.out.println("Invalid weight!");
            }

            String activity;
            while (true) {
                System.out.print("Activity Level (Low/Moderate/High): ");
                activity = sc.nextLine();
                if (activity.equalsIgnoreCase("Low") || activity.equalsIgnoreCase("Moderate") || activity.equalsIgnoreCase("High")) {
                    activity = activity.substring(0, 1).toUpperCase() + activity.substring(1).toLowerCase();
                    break;
                }
                System.out.println("Invalid input!");
            }

            System.out.print("Password: ");
            String pass = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO users(email,name,age,gender,height,weight,activity_level,password) VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, gender);
            ps.setDouble(5, height);
            ps.setDouble(6, weight);
            ps.setString(7, activity);
            ps.setString(8, pass);
            ps.executeUpdate();

            System.out.println("Registration successful!");
        } catch (Exception e) {
            System.out.println("Error during registration: " + e.getMessage());
        }
    }

    // User login
    private void login() {
        try {
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Password: ");
            String pass = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                currentUserId = rs.getInt("id");
                currentUserName = rs.getString("name");
                currentGender = rs.getString("gender");
                currentAge = rs.getInt("age");
                currentActivity = rs.getString("activity_level");
                currentHeight = rs.getDouble("height");
                currentWeight = rs.getDouble("weight");
                System.out.println("\nWelcome " + currentUserName + "!");
                userMenu();
            } else System.out.println("Invalid email or password.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // User options
    private void userMenu() {
        while (true) {
            System.out.println("\n==== PERSONAL MENU ====");
            System.out.println("1. Calculate BMI");
            System.out.println("2. View BMI History");
            System.out.println("3. View Recommended Diet");
            System.out.println("4. View Daily Calorie Needs");
            System.out.println("5. Edit Profile");
            System.out.println("6. Logout");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> calculateBMI();
                case 2 -> viewHistory();
                case 3 -> viewDiet();
                case 4 -> viewCalories();
                case 5 -> editProfile();
                case 6 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void calculateBMI() {
        try {
            double bmi = BMICalculator.calculateBMI(currentHeight, currentWeight);
            String cat = BMICalculator.getCategory(bmi);

            PreparedStatement ps2 = conn.prepareStatement(
                    "INSERT INTO bmi_logs(user_id,bmi_value,category) VALUES(?,?,?)");
            ps2.setInt(1, currentUserId);
            ps2.setDouble(2, bmi);
            ps2.setString(3, cat);
            ps2.executeUpdate();

            System.out.printf("BMI: %.2f (%s)%n", bmi, cat);
        } catch (Exception e) {
            System.out.println("Error calculating BMI: " + e.getMessage());
        }
    }

    private void viewHistory() {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM bmi_logs WHERE user_id=? ORDER BY date_logged DESC");
            ps.setInt(1, currentUserId);
            ResultSet rs = ps.executeQuery();
            List<String> history = new ArrayList<>();
            while (rs.next()) {
                history.add(String.format("%.2f (%s) on %s",
                        rs.getDouble("bmi_value"),
                        rs.getString("category"),
                        rs.getTimestamp("date_logged")));
            }
            if (history.isEmpty()) System.out.println("No records found.");
            else DatabaseHandler.printList(history);
        } catch (Exception e) {
            System.out.println("Error fetching history: " + e.getMessage());
        }
    }

    private void viewDiet() {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT recommended_foods FROM diet_plans WHERE bmi_category=(" +
                            "SELECT category FROM bmi_logs WHERE user_id=? ORDER BY date_logged DESC LIMIT 1)");
            ps.setInt(1, currentUserId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) System.out.println("Diet: " + rs.getString("recommended_foods"));
            else System.out.println("No BMI records found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewCalories() {
        try {
            double cal = BMICalculator.calculateCalories(currentGender, currentWeight, currentHeight, currentAge, currentActivity);
            System.out.printf("Daily Calories (Maintenance): %.2f kcal%n", cal);
        } catch (Exception e) {
            System.out.println("Error calculating calories: " + e.getMessage());
        }
    }

    private void editProfile() {
        try {
            System.out.print("New height (m): ");
            currentHeight = sc.nextDouble();
            System.out.print("New weight (kg): ");
            currentWeight = sc.nextDouble();
            sc.nextLine();
            System.out.print("New activity level (Low/Moderate/High): ");
            currentActivity = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE users SET height=?,weight=?,activity_level=? WHERE id=?");
            ps.setDouble(1, currentHeight);
            ps.setDouble(2, currentWeight);
            ps.setString(3, currentActivity);
            ps.setInt(4, currentUserId);
            ps.executeUpdate();

            System.out.println("Profile updated!");
        } catch (Exception e) {
            System.out.println("Error updating profile: " + e.getMessage());
        }
    }
}
