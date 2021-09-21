package budget;

public class SortByType extends SortingAlgorithm {
    @Override
    public void sort() {
        if (Food.map.size() == 0 && Clothes.map.size() == 0
                && Entertainment.map.size() == 0 && Other.map.size() == 0) {
            System.out.println("Types");
            System.out.println("Food - $0");
            System.out.println("Clothes - $0");
            System.out.println("Entertainment - $0");
            System.out.println("Other - $0");
            System.out.println("Total sum: $0");
        } else {
            names.add("Food");
            prices.add(Food.totalCost);
            names.add("Clothes");
            prices.add(Clothes.totalCost);
            names.add("Entertainment");
            prices.add(Entertainment.totalCost);
            names.add("Other");
            prices.add(Other.totalCost);

            actualSorting();

            System.out.println("Types:");
            for (int i = 0; i < prices.size(); i++) {
                System.out.printf("%s - $%.2f\n", names.get(i), prices.get(i));
            }
            double allCost = Food.totalCost + Clothes.totalCost +
                    Entertainment.totalCost + Other.totalCost;
            System.out.printf("Total sum: $%.2f\n", allCost);
        }
    }
}
