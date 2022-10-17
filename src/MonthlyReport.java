import java.util.HashMap;
import java.util.List;

public class MonthlyReport {
    HashMap<String, List<Integer>> expenses;
    HashMap<String, List<Integer>> incomes;

    public MonthlyReport() {
        expenses = new HashMap<>();
        incomes = new HashMap<>();
    }

    @Override
    public String toString() {
        return "MonthlyReport{" +
                "expenses=" + expenses +
                ", incomes=" + incomes +
                '}';
    }
}
