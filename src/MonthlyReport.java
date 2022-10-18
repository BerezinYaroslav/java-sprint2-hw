import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {
    int monthNumber;
    List<MonthIncomesAndExpenses> incomesAndExpenses = new ArrayList<>();
    String[] monthsNames = {
            "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
    };

    public MonthlyReport(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public void printMonthlyReportInformation() {
        System.out.println("Месяц " + this.getMonthName());
        System.out.println("Самый прибыльный товар - " + this.getMostProfitablePositionOrBiggestExpense(1));
        System.out.println("Самая большая трата - " + this.getMostProfitablePositionOrBiggestExpense(2));
    }

    public String getMostProfitablePositionOrBiggestExpense(int mode) {
        String incomePosition = "";
        String expensePosition = "";
        int maxIncome = 0;
        int maxExpense = 0;

        for (MonthIncomesAndExpenses month : incomesAndExpenses) {
            if (month.is_expense) {
                int expense = month.quantity * month.sum_of_one;

                if (expense > maxExpense) {
                    maxExpense = expense;
                    expensePosition = month.item_name;
                }
            } else {
                int income = month.quantity * month.sum_of_one;

                if (income > maxIncome) {
                    maxIncome = income;
                    incomePosition = month.item_name;
                }
            }
        }

        if (mode == 1) {
            return incomePosition;
        } else {
            return expensePosition;
        }
    }

    public String getMonthName() {
        return monthsNames[monthNumber];
    }

    public int calculateAllIncomesOrExpenses(int mode) {
        int incomesSum = 0;
        int expenseSum = 0;

        for (MonthIncomesAndExpenses month : incomesAndExpenses) {
            if (!month.is_expense) {
                incomesSum += month.quantity * month.sum_of_one;
            } else {
                expenseSum += month.quantity * month.sum_of_one;
            }
        }

        if (mode == 1) {
            return incomesSum;
        } else {
            return expenseSum;
        }
    }
}
