package budget;

import java.util.ArrayList;
import java.util.List;

public abstract class SortingAlgorithm {
    List<String> names = new ArrayList<>();
    List<Double> prices = new ArrayList<>();

    abstract void sort();

    void actualSorting() {
        for (int i = 0; i < prices.size() - 1; i++) {
            for (int j = 0; j < prices.size() - i - 1; j++) {
                if (prices.get(j) < prices.get(j + 1)) {
                    double temp1 = prices.get(j);
                    prices.set(j, prices.get(j + 1));
                    prices.set(j + 1, temp1);

                    String temp2 = names.get(j);
                    names.set(j, names.get(j + 1));
                    names.set(j + 1, temp2);
                }
            }
        }
    }
}
