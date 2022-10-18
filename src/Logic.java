import java.util.List;

public class Logic {
    public void printDataReconciliation(List<MonthlyReport> monthlyReports, YearlyReport yearlyReport) {
        boolean allIsRight = true;
        System.out.println("Сверка отчётов:");

        for (int i = 0; i < monthlyReports.size(); i++) {
            if (monthlyReports.get(i).calculateAllIncomesOrExpenses(1) != yearlyReport.getExpensesOrIncomeByMonth(i, 1)) {
                System.out.println("Ошибка: доходы не сходятся");
                allIsRight = false;
            }

            if (monthlyReports.get(i).calculateAllIncomesOrExpenses(2) != yearlyReport.getExpensesOrIncomeByMonth(i, 2)) {
                System.out.println("Месяц " + (i + 1) + ". Ошибка: расходы не сходятся");
                allIsRight = false;
            }
        }

        if (allIsRight) {
            System.out.println("Сверка отчётов прошла успешно");
        }
    }

    public boolean isFilesRead(boolean monthlyReportsIsRead, boolean yearlyReportsIsRead) {
        if (monthlyReportsIsRead && yearlyReportsIsRead) {
            return true;
        }  else {
            System.out.println("Для сверки отчётов необходимо для начала считать их (команды 1 и 2)");
            return false;
        }
    }
}
