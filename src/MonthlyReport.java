import java.util.HashMap;
import java.util.List;

public class MonthlyReport {
    int monthNumber;
    String[] monthsNames = {
            "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
    };

    HashMap<String, List<Integer>> expenses;
    HashMap<String, List<Integer>> incomes;

    public String getMostProfitablePosition() {
        int maxProfit = 0;
        String position = "";

        for (String key : incomes.keySet()) {
            int profit = incomes.get(key).get(0) * incomes.get(key).get(1);
            if (profit > maxProfit) {
                maxProfit = profit;
                position = key;
            }
        }

        return position;
    }

    public String getBiggestExpense() {
        int maxExpense = 0;
        String position = "";

        for (String key : expenses.keySet()) {
            int expense = expenses.get(key).get(0) * expenses.get(key).get(1);
            if (expense > maxExpense) {
                maxExpense = expense;
                position = key;
            }
        }

        return position + " (" + maxExpense + ")";
    }

    public MonthlyReport(int monthNumber) {
        this.monthNumber = monthNumber;
        expenses = new HashMap<>();
        incomes = new HashMap<>();
    }

    public String getMonthName() {
        return monthsNames[monthNumber];
    }

    public int calculateAllIncomes() {
        int incomesSum = 0;

        for (List<Integer> list : incomes.values()) {
            incomesSum += list.get(0) * list.get(1);
        }

        return incomesSum;
    }

    public int calculateAllExpenses() {
        int expenseSum = 0;

        for (List<Integer> list : expenses.values()) {
            expenseSum += list.get(0) * list.get(1);
        }

        return expenseSum;
    }
}
