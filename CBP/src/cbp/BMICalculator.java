package cbp;

/**
 * Handles BMI and calorie calculations.
 * Demonstrates Method Overloading, Static Methods, and Exception Handling.
 */
public class BMICalculator {

    // Constructor
    public BMICalculator() {
        System.out.println("BMICalculator initialized.");
    }

    // Method Overloading Example
    public static double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }

    // Overloaded version (demonstrates polymorphism)
    public static double calculateBMI(double height, double weight, int age) {
        double bmi = weight / (height * height);
        // Slight age factor adjustment (for demonstration)
        return age > 50 ? bmi + 0.5 : bmi;
    }

    public static String getCategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static double calculateCalories(String gender, double weight, double height, int age, String activityLevel) {
        double bmr;
        if (gender.equalsIgnoreCase("Male"))
            bmr = 88.36 + (13.4 * weight) + (4.8 * (height * 100)) - (5.7 * age);
        else
            bmr = 447.6 + (9.2 * weight) + (3.1 * (height * 100)) - (4.3 * age);

        double factor = switch (activityLevel.toLowerCase()) {
            case "low" -> 1.2;
            case "moderate" -> 1.55;
            case "high" -> 1.725;
            default -> 1.2;
        };

        return bmr * factor;
    }
}
