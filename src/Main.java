import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadUtil readUtil = new ReadUtil();
        PrintUtil printUtil = new PrintUtil();
        Logic logic = new Logic();

        List<MonthlyReport> monthlyReports = new ArrayList<>();
        YearlyReport yearlyReport = new YearlyReport(2021);

        boolean monthlyReportsIsRead = false;
        boolean yearlyReportsIsRead = false;

        while (true) {
            printUtil.printMenu();
            int command = scanner.nextByte();

            switch (command) {
                case 1: {
                    readUtil.readAndSaveMonthlyReports(monthlyReports);
                    System.out.println("Месячные отчёты посчитаны");
                    monthlyReportsIsRead = true;
                    break;
                }

                case 2: {
                    readUtil.readAndSaveYearlyReport("resources/y." + yearlyReport.yaer + ".csv", yearlyReport);
                    System.out.println("Годовой отчёт посчитан");
                    yearlyReportsIsRead = true;
                    break;
                }

                case 3: {
                    if (logic.isFilesRead(monthlyReportsIsRead, yearlyReportsIsRead)) {
                        logic.printDataReconciliation(monthlyReports, yearlyReport);
                    }

                    break;
                }

                case 4: {
                    if (logic.isFilesRead(monthlyReportsIsRead, yearlyReportsIsRead)) {
                        for (MonthlyReport month : monthlyReports) {
                            month.printMonthlyReportInformation();
                        }
                    }

                    break;
                }

                case 5: {
                    if (logic.isFilesRead(monthlyReportsIsRead, yearlyReportsIsRead)) {
                        yearlyReport.printYearlyReportInformation();
                    }

                    break;
                }

                case 111: {
                    System.out.println("Выход");
                    return;
                }

                default:
                    System.out.println("Извините, такой команды нет, попробуйте снова");
            }
        }
    }
}

