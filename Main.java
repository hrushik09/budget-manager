package budget;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static double balance = 0;

    public static void main(String[] args) throws IOException {
        mainMenu();
    }

    static void mainMenu() throws IOException {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("7) Analyze (Sort)");
        System.out.println("0) Exit");
        initializeMainMenuActions();
    }
    static void initializeMainMenuActions() throws IOException {
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println();

        switch (choice) {
            case 1:
                addIncome();
                break;

            case 2:
                addPurchase();
                break;

            case 3:
                showPurchases();
                break;

            case 4:
                showBalance();
                break;

            case 5:
                SaveData.writeData();
                break;

            case 6:
                LoadData.readData();
                break;

            case 7:
                analyze();
                break;

            case 0:
                exit();
        }
    }

    static void addIncome() throws IOException {
        System.out.println("Enter income");
        int temp = Integer.parseInt(scanner.nextLine());
        balance += temp;
        System.out.println("Income was added!");
        System.out.println();
        mainMenu();
    }

    static void addPurchase() throws IOException {
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");
        initializeAddPurchaseMenuActions();
    }

    static void initializeAddPurchaseMenuActions() throws IOException {
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println();

        switch (choice) {
            case 1:
                Food.addPurchase();
                break;

            case 2:
                Clothes.addPurchase();
                break;

            case 3:
                Entertainment.addPurchase();
                break;

            case 4:
                Other.addPurchase();
                break;

            case 5:
                mainMenu();
                break;
        }
    }

    static void showPurchases() throws IOException {
        if (Food.map.size() == 0 && Clothes.map.size() == 0
                && Entertainment.map.size() == 0 && Other.map.size() == 0) {
            System.out.println("The purchase list is empty!");
            mainMenu();
        } else {
            System.out.println("Choose the type of purchases");
            System.out.println("1) Food");
            System.out.println("2) Clothes");
            System.out.println("3) Entertainment");
            System.out.println("4) Other");
            System.out.println("5) All");
            System.out.println("6) Back");
            initializeShowPurchasesMenuActions();
        }
    }

    static void initializeShowPurchasesMenuActions() throws IOException {
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println();

        switch (choice) {
            case 1:
                Food.showPurchases();
                break;

            case 2:
                Clothes.showPurchases();
                break;

            case 3:
                Entertainment.showPurchases();
                break;

            case 4:
                Other.showPurchases();
                break;

            case 5:
                System.out.println("All:");
                Food.showOnlyEntries();
                Clothes.showOnlyEntries();
                Entertainment.showOnlyEntries();
                Other.showOnlyEntries();
                double allCost = Food.totalCost + Clothes.totalCost +
                        Entertainment.totalCost + Other.totalCost;
                System.out.printf("Total sum: $%.2f\n", allCost);
                System.out.println();
                showPurchases();
                break;

            case 6:
                mainMenu();
                break;
        }
    }

    static void showBalance() throws IOException {
        System.out.printf("Balance: $%.2f\n", balance);
        System.out.println();
        mainMenu();
    }

    static void analyze() throws IOException {
        System.out.println("How do you want to sort?");
        System.out.println("1) Sort all purchases");
        System.out.println("2) Sort by type");
        System.out.println("3) Sort certain type");
        System.out.println("4) Back");
        initializeAnalyzeMenuActions();
    }

    static void initializeAnalyzeMenuActions() throws IOException {
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println();

        Context context = new Context();

        switch (choice) {
            case 1:
                context.setSortingAlgorithm(new SortAll());
                context.sort();
                System.out.println();
                analyze();
                break;

            case 2:
                context.setSortingAlgorithm(new SortByType());
                context.sort();
                System.out.println();
                analyze();
                break;

            case 3:
                context.setSortingAlgorithm(new SortCertainType());
                context.sort();
                System.out.println();
                analyze();
                break;

            case 4:
                mainMenu();
                break;
        }
    }

    static void exit() {
        System.out.println("Bye!");
    }
}
