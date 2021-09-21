package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LoadData {
    static String pathToFile = "purchases.txt";

    static void readData() throws IOException {
        resetPurchaseData();

        File file = new File(pathToFile);
        try (Scanner scanner = new Scanner(file)) {
            String currentStr = scanner.nextLine();

            // Balance
            if ("Balance".equals(currentStr)) {
                Main.balance = Double.parseDouble(scanner.nextLine());
                scanner.nextLine();
            } else {
                System.out.println("Error while reading balance");
            }

            // Purchases
            while (scanner.hasNextLine()) {
                currentStr = scanner.nextLine();
                String n = scanner.nextLine();
                double p = Double.parseDouble(scanner.nextLine());

                switch (currentStr) {
                    case "Food":
                        Food.map.put(p, n);
                        Food.totalCost += p;
                        break;

                    case "Clothes":
                        Clothes.map.put(p, n);
                        Clothes.totalCost += p;
                        break;

                    case "Entertainment":
                        Entertainment.map.put(p, n);
                        Entertainment.totalCost += p;
                        break;

                    case "Other":
                        Other.map.put(p, n);
                        Other.totalCost += p;
                        break;

                    default:
                        System.out.println("Error while reading purchases");
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }

        System.out.println("Purchases were loaded!");
        System.out.println();
        Main.mainMenu();
    }

    static void resetPurchaseData() {
        Main.balance = 0;

        Food.totalCost = 0;
        Clothes.totalCost = 0;
        Entertainment.totalCost = 0;
        Other.totalCost = 0;

        Food.map = new HashMap<>();
        Clothes.map = new HashMap<>();
        Entertainment.map = new HashMap<>();
        Other.map = new HashMap<>();
    }
}
