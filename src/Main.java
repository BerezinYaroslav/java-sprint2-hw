import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadUtil readUtil = new ReadUtil();
        ReportLogic reportLogic = new ReportLogic();

        List<MonthlyReport> monthlyReports = new ArrayList<>();
        YearlyReport yearlyReport = new YearlyReport(2021);

        boolean monthlyReportsIsRead = false;
        boolean yearlyReportsIsRead = false;

        while (true) {
            printMenu();
            int command = scanner.nextByte();

            switch (command) {
                case 1: {
                    readUtil.readAndSaveMonthlyReports(monthlyReports);
                    System.out.println("Месячные отчёты считаны");
                    monthlyReportsIsRead = true;
                    break;
                }

                case 2: {
                    readUtil.readAndSaveYearlyReport("resources/y." + yearlyReport.yaer + ".csv", yearlyReport);
                    System.out.println("Годовой отчёт считан");
                    yearlyReportsIsRead = true;
                    break;
                }

                case 3: {
                    if (reportLogic.isFilesRead(monthlyReportsIsRead, yearlyReportsIsRead)) {
                        reportLogic.printDataReconciliation(monthlyReports, yearlyReport);
                    }

                    break;
                }

                case 4: {
                    if (reportLogic.isMonthlyFilesRead(monthlyReportsIsRead)) {
                        for (MonthlyReport month : monthlyReports) {
                            month.printMonthlyReportInformation();
                        }
                    }

                    break;
                }

                case 5: {
                    if (reportLogic.isYearlyFilesRead(yearlyReportsIsRead)) {
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

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("111 - Выйти");
    }
}