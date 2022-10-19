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

    public String getMostProfitablePositionOrBiggestExpense(int modeIncomeOrExpanse) {
        String position = "";
        int maxSum = 0;
        boolean isExpense = (modeIncomeOrExpanse != 1);

        for (MonthIncomesAndExpenses month : incomesAndExpenses) {
            if (month.isExpense == isExpense) {
                int sum = month.quantity * month.sumOfOne;

                if (sum > maxSum) {
                    maxSum = sum;
                    position = month.itemName;
                }
            }
        }

        return position;
    }

    public String getMonthName() {
        return monthsNames[monthNumber];
    }

    public int calculateAllIncomesOrExpenses(int modeIncomeOrExpanse) {
        int sum = 0;
        boolean isExpense = (modeIncomeOrExpanse != 1);

        for (MonthIncomesAndExpenses month : incomesAndExpenses) {
            if (month.isExpense == isExpense) {
                sum += month.quantity * month.sumOfOne;
            }
        }

        return sum;
    }
}
