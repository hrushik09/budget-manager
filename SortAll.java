package budget;

public class SortAll extends SortingAlgorithm {
    @Override
    public void sort() {
        if (Food.map.size() == 0 && Clothes.map.size() == 0
                && Entertainment.map.size() == 0 && Other.map.size() == 0) {
            System.out.println("The purchase list is empty!");
        } else {
            names.addAll(Food.map.values());
            prices.addAll(Food.map.keySet());
            names.addAll(Clothes.map.values());
            prices.addAll(Clothes.map.keySet());
            names.addAll(Entertainment.map.values());
            prices.addAll(Entertainment.map.keySet());
            names.addAll(Other.map.values());
            prices.addAll(Other.map.keySet());

            actualSorting();

            System.out.println("All:");
            for (int i = 0; i < prices.size(); i++) {
                System.out.printf("%s $%.2f\n", names.get(i), prices.get(i));
            }
            double allCost = Food.totalCost + Clothes.totalCost +
                    Entertainment.totalCost + Other.totalCost;
            System.out.printf("Total sum: $%.2f\n", allCost);
        }
    }
}
