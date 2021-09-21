package budget;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Clothes {
    static Scanner scanner = new Scanner(System.in);
    static double totalCost = 0;
    static Map<Double, String> map = new HashMap<>();

    static void addPurchase() throws IOException {
        System.out.println("Enter purchase name:");
        String n = scanner.nextLine();
        System.out.println("Enter its price:");
        double p = Double.parseDouble(scanner.nextLine());
        map.put(p, n);
        if (Main.balance - p >= 0) {
            Main.balance -= p;
        }
        totalCost += p;
        System.out.println("Purchase was added!");
        System.out.println();
        Main.addPurchase();
    }

    static void showPurchases() throws IOException {
        System.out.println("Clothes:");
        if (map.size() == 0) {
            System.out.println("The purchase list is empty!");
        } else {
            for (Map.Entry<Double, String> entry : map.entrySet()) {
                System.out.printf("%s $%.2f\n", entry.getValue(), entry.getKey());
            }
            System.out.printf("Total sum: $%.2f\n", totalCost);
        }
        System.out.println();
        Main.showPurchases();
    }

    static void showOnlyEntries() {
        for (Map.Entry<Double, String> entry : map.entrySet()) {
            System.out.printf("%s $%.2f\n", entry.getValue(), entry.getKey());
        }
    }
}
