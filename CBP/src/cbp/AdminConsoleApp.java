package cbp;

import java.sql.*;
import java.util.*;

/**
 * AdminConsoleApp – manages user data.
 * Demonstrates Inheritance, Method Overriding, Collections, and JDBC.
 */
public class AdminConsoleApp extends UserConsoleApp {

    public AdminConsoleApp(Connection conn) {
        super(conn);
    }

    // Overridden start() → demonstrates Polymorphism (Overriding)
    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter admin password: ");
        String pass = sc.nextLine();

        if (!pass.equals("admin123")) {
            System.out.println("Access denied!");
            return;
        }

        while (true) {
            System.out.println("\n==== ADMIN PANEL ====");
            System.out.println("1. View All Users");
            System.out.println("2. Delete User");
            System.out.println("3. Back");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> viewUsers();
                case 2 -> deleteUser(sc);
                case 3 -> {
                    System.out.println("Returning to main menu...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void viewUsers() {
        try {
            Statement st = super.conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name, email, height, weight FROM users");

            List<String> users = new ArrayList<>();

            System.out.printf("%-5s %-20s %-25s %-10s %-10s%n",
                    "ID", "NAME", "EMAIL", "HEIGHT(m)", "WEIGHT(kg)");
            System.out.println("--------------------------------------------------------------------------");

            while (rs.next()) {
                users.add(String.format("%-5d %-20s %-25s %-10.2f %-10.2f",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("height"),
                        rs.getDouble("weight")));
            }

            if (users.isEmpty()) {
                System.out.println("No users found in the database.");
            } else {
                DatabaseHandler.printList(users);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching users: " + e.getMessage());
        }
    }


    private void deleteUser(Scanner sc) {
        System.out.print("Enter user ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        try {
            PreparedStatement ps = super.conn.prepareStatement("DELETE FROM users WHERE id=?");
            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("User deleted successfully!");
            else
                System.out.println("User not found.");
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }
}
