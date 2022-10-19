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

    public void printYearlyReportInformation() {
        System.out.println(this.yaer);

        for (int i = 0; i < this.expenses.size(); i++) {
            MonthlyReport monthlyReport = new MonthlyReport(i);
            System.out.println("Прибыль за " + monthlyReport.getMonthName() + " - " + this.getProfitByMonth(i));
        }

        System.out.println("Средний расход за все месяцы - " + this.getAverageIncomeOrExpense(2));
        System.out.println("Средний доход за все месяцы - " + this.getAverageIncomeOrExpense(1));
    }

    public int getIncomesOrExpenseSum(int modeIncomeOrExpanse) {
        int sum = 0;
        HashMap<String, Integer> hashMap;

        if (modeIncomeOrExpanse == 1) {
            hashMap = incomes;
        } else {
            hashMap = expenses;
        }

        for (int number : hashMap.values()) {
            sum += number;
        }

        return sum;
    }

    public int getAverageIncomeOrExpense(int modeIncomeOrExpanse) {
        return getIncomesOrExpenseSum(modeIncomeOrExpanse) / incomes.size();
    }

    public int getProfitByMonth(int monthNumber) {
        return getExpensesOrIncomeByMonth(monthNumber, 1) - getExpensesOrIncomeByMonth(monthNumber, 2);
    }

    public int getExpensesOrIncomeByMonth(int monthNumber, int modeIncomeOrExpanse) {
        if (modeIncomeOrExpanse == 1) {
            return incomes.get("0" + (monthNumber + 1));
        } else {
            return expenses.get("0" + (monthNumber + 1));
        }
    }
}
