import java.util.List;

public class PrintUtil {
    public void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("111 - Выйти");
    }

    public void printYearlyReportInformation(YearlyReport yearlyReport) {
        System.out.println(yearlyReport.yaer);

        for (int i = 0; i < yearlyReport.expenses.size(); i++) {
            MonthlyReport monthlyReport = new MonthlyReport(i);
            System.out.println("Прибыль за " + monthlyReport.getMonthName() + " - " + yearlyReport.getProfitByMonth(i));
        }

        System.out.println("Средний расход за все месяцы - " + yearlyReport.getAverageExpense());
        System.out.println("Средний доход за все месяцы - " + yearlyReport.getAverageIncome());
    }

    public void printMonthlyReportInformation(MonthlyReport monthlyReport) {
        System.out.println("Месяц " + monthlyReport.getMonthName());
        System.out.println("Самый прибыльный товар - " + monthlyReport.getMostProfitablePosition());
        System.out.println("Самая большая трата - " + monthlyReport.getBiggestExpense());
    }

    public void printDataReconciliation(List<MonthlyReport> monthlyReports, YearlyReport yearlyReport) {
        boolean allIsRight = true;

        System.out.println("Сверка отчётов:");

        for (int i = 0; i < monthlyReports.size(); i++) {
            if (monthlyReports.get(i).calculateAllIncomes() != yearlyReport.getIncomesByMonth(i)) {
                System.out.println("Ошибка: доходы не сходятся");
                allIsRight = false;
            }

            if (monthlyReports.get(i).calculateAllExpenses() != yearlyReport.getExpensesByMonth(i)) {
                System.out.println("Месяц " + (i + 1) + ". Ошибка: расходы не сходятся");
                allIsRight = false;
            }
        }

        if (allIsRight) {
            System.out.println("Сверка отчётов прошла успешно");
        }
    }
}
