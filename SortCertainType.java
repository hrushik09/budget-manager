package budget;

import java.util.Scanner;

public class SortCertainType extends SortingAlgorithm {
    @Override
    public void sort() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");

        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println();
        switch (choice) {
            case 1:
                if (Food.map.size() == 0) {
                    System.out.println("The purchase list is empty!");
                } else {
                    names.addAll(Food.map.values());
                    prices.addAll(Food.map.keySet());
                    System.out.println("Food:");
                    actualSorting();

                    for (int i = 0; i < prices.size(); i++) {
                        System.out.printf("%s $%.2f\n", names.get(i), prices.get(i));
                    }
                    System.out.printf("Total sum: $%.2f\n", Food.totalCost);
                }
                break;

            case 2:
                if (Clothes.map.size() == 0) {
                    System.out.println("The purchase list is empty!");
                } else {
                    names.addAll(Clothes.map.values());
                    prices.addAll(Clothes.map.keySet());
                    System.out.println("Clothes:");
                    actualSorting();

                    for (int i = 0; i < prices.size(); i++) {
                        System.out.printf("%s $%.2f\n", names.get(i), prices.get(i));
                    }
                    System.out.printf("Total sum: $%.2f\n", Clothes.totalCost);
                }
                break;

            case 3:
                if (Entertainment.map.size() == 0) {
                    System.out.println("The purchase list is empty!");
                } else {
                    names.addAll(Entertainment.map.values());
                    prices.addAll(Entertainment.map.keySet());
                    System.out.println("Entertainment:");
                    actualSorting();

                    for (int i = 0; i < prices.size(); i++) {
                        System.out.printf("%s $%.2f\n", names.get(i), prices.get(i));
                    }
                    System.out.printf("Total sum: $%.2f\n", Entertainment.totalCost);
                }
                break;

            case 4:
                if (Other.map.size() == 0) {
                    System.out.println("The purchase list is empty!");
                } else {
                    names.addAll(Other.map.values());
                    prices.addAll(Other.map.keySet());
                    System.out.println("Other:");
                    actualSorting();

                    for (int i = 0; i < prices.size(); i++) {
                        System.out.printf("%s $%.2f\n", names.get(i), prices.get(i));
                    }
                    System.out.printf("Total sum: $%.2f\n", Other.totalCost);
                }
                break;
        }
    }
}
