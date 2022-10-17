import java.util.HashMap;

public class YearlyReport {
    int yaer;
    HashMap<String, Integer> expenses;
    HashMap<String, Integer> incomes;

    public YearlyReport(int year) {
        this.yaer = year;
        expenses = new HashMap<>();
        incomes = new HashMap<>();
    }

    public int getIncomesSum() {
        int sum = 0;

        for (int income : incomes.values()) {
            sum += income;
        }

        return sum;
    }

    public int getExpensesSum() {
        int sum = 0;

        for (int expense : expenses.values()) {
            sum += expense;
        }

        return sum;
    }

    public int getAverageIncome() {
        return getIncomesSum() / incomes.size();
    }

    public int getAverageExpense() {
        return getExpensesSum() / expenses.size();
    }

    public int getProfitByMonth(int monthNumber) {
        return getIncomesByMonth(monthNumber) - getExpensesByMonth(monthNumber);
    }

    public int getExpensesByMonth(int monthNumber) {
        return expenses.get("0" + (monthNumber + 1));
    }

    public int getIncomesByMonth(int monthNumber) {
        return incomes.get("0" + (monthNumber + 1));
    }
}
