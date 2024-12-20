package pocketChangeOop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * This class implements the Pocket Change Manager's various features.
 * Uses OOP principles.
 * Each feature is encapsulated as a method.
 */

public class PocketChangeManagerOOP {
    // Properties
    // Define relevant variables
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    // 2. Record pocket change details
    // Approach:
    // (1) Store income and expenditure records in an array (might require a dynamic array)
    // (2) Use objects
    // ¡Ì(3) Use string concatenation
    String details = "---------------Pocket Change Details----------------";

    // 3. Add income feature. Functional development introduces new logic and code changes.
    // Define additional variables
    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm"); // For date formatting

    // 4. Expenditure feature
    // Define a new variable to store the reason for expenditure
    String note = "";

    // Display the main menu and handle selections
    public void mainMenu() {
        // Use do-while to ensure the menu is displayed at least once
        do {
            System.out.println("\n==============Pocket Change Menu(OOP)==============");
            System.out.println("\t\t\t1 Pocket Change Details");
            System.out.println("\t\t\t2 Add Income");
            System.out.println("\t\t\t3 Expenditure");
            System.out.println("\t\t\t4 Exit");

            System.out.print("Please select (1-4): ");
            key = scanner.next();

            // Use switch control
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.addIncome();
                    break;
                case "3":
                    this.expenditure();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("Invalid selection, please try again.");
            }
        } while (loop);

        System.out.println("You have exited the Pocket Change system. Thank you for using it!");
    }

    public void detail() {
        System.out.println("1 Pocket Change Details");
        System.out.println(details);
    }

    public void addIncome() {
        System.out.println("2 Add Income");
        System.out.print("Enter income amount: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a valid number.\nEnter income amount: ");
            scanner.next(); // Clear invalid input
        }
        money = scanner.nextDouble();

        // Validate the income amount
        if (money <= 0) {
            System.out.println("The income amount must be greater than 0.");
            return; // Exit the method without executing further code
        }

        balance += money;
        // Append income details to the 'details' string
        date = new Date();
        details += "\nIncome\t\t + " + money + "\t" + sdf.format(date) + "\tBalance: " + balance;
    }

    public void expenditure() {
        System.out.println("3 Expenditure");
        System.out.print("Enter expenditure amount: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a valid number.\nEnter expenditure amount: ");
            scanner.next(); // Clear invalid input
        }
        money = scanner.nextDouble();

        // Validate the expenditure amount
        if (money <= 0 || money > balance) {
            System.out.println("The expenditure amount must be between 0.0 and " + balance);
            return;
        }

        System.out.print("Reason for expenditure: ");
        scanner.nextLine(); // Read the remaining newline to avoid input skipping
        note = scanner.nextLine();

        balance -= money;

        // Append expenditure details to the 'details' string
        date = new Date();
        details += "\nExpenditure\t - " + money + "\t" + sdf.format(date) + "\tBalance: " + balance + "\t" + note;
    }

    public void exit() {
        // When the user selects 4 to exit, prompt "Are you sure you want to exit? y/n".
        // Input must be either 'y' or 'n', otherwise, the loop continues.
        System.out.println("4 Exit");
        String choice = "";
        while (true) { // Require user to input 'y' or 'n', otherwise keep looping
            System.out.println("Are you sure you want to exit? y/n");
            choice = scanner.next();
            if ("y".equalsIgnoreCase(choice) || "n".equalsIgnoreCase(choice)) {
                break;
            }
        }

        // Determine the user's choice after exiting the loop
        if (choice.equalsIgnoreCase("y")) {
            loop = false;
        }
        // If the user chooses 'n', do nothing
    }
}
