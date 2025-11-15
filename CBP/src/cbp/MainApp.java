package cbp;

import java.sql.*;
import java.util.Scanner;

/**
 * MainApp – Entry point for the CBP system.
 * Demonstrates Constructor, Exception Handling, and Polymorphism (method overloading).
 */
public class MainApp {

    // Constructor (demonstration)
    public MainApp() {
        System.out.println("\n=====================================");
        System.out.println("       Calorie & BMI Tracker App       ");
        System.out.println("======================================");
    }

    // Method Overloading – same name, different parameters
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    public void displayMessage(String msg, boolean highlight) {
        if (highlight) System.out.println("*** " + msg.toUpperCase() + " ***");
        else System.out.println(msg);
    }

    public static void main(String[] args) {
        MainApp app = new MainApp(); // Object creation → Demonstrates Class & Object
        Connection conn = DatabaseHandler.connect(); // JDBC usage
        if (conn == null) return;

        Scanner sc = new Scanner(System.in);
        UserConsoleApp userApp = new UserConsoleApp(conn);
        AdminConsoleApp adminApp = new AdminConsoleApp(conn);

        // Main program loop
        while (true) {
            System.out.println("\n==== MAIN MENU ====");
            System.out.println("1. User Panel");
            System.out.println("2. Admin Panel");
            System.out.println("3. General BMI Calculator");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> userApp.start();
                case 2 -> adminApp.start();
                case 3 -> {
                    try {
                        System.out.print("Enter height (m): ");
                        double height = sc.nextDouble();
                        System.out.print("Enter weight (kg): ");
                        double weight = sc.nextDouble();

                        double bmi = BMICalculator.calculateBMI(height, weight);
                        String category = BMICalculator.getCategory(bmi);
                        app.displayMessage(String.format("BMI: %.2f (%s)", bmi, category), true);
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter valid numbers.");
                    }
                }
                case 4 -> {
                    app.displayMessage("Thank you for using our app . Stay healthy!", true);
                    return;
                }
                default -> app.displayMessage("Invalid choice. Try again!");
            }
        }
    }
}
