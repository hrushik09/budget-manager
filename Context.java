package budget;

public class Context {
    SortingAlgorithm sortingAlgorithm;

    public void setSortingAlgorithm(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void sort() {
        this.sortingAlgorithm.sort();
    }
}
