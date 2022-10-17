import java.util.HashMap;

public class YearlyReport {
    HashMap<String, Integer> expenses;
    HashMap<String, Integer> incomes;

    public YearlyReport() {
        expenses = new HashMap<>();
        incomes = new HashMap<>();
    }

    public int getMaxMinAverage(String optional) {
        int max = 9999;
        int min = -9999;
        int sum = 0;
        int average;

        for (int expense: expenses.values()) {
            if (expense > max) {
                max = expense;
            }

            if (expense < min) {
                min = expense;
            }

            sum += expense;
        }

        for (int income: incomes.values()) {
            if (income > max) {
                max = income;
            }

            if (income < min) {
                min = income;
            }

            sum += income;
        }

        average = sum / (expenses.size() + incomes.size());

        switch (optional) {
            case "max": return max;
            case "min": return min;
            case "average": return average;
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return "YearlyReport{" +
                "expenses=" + expenses +
                ", incomes=" + incomes +
                '}';
    }
}
