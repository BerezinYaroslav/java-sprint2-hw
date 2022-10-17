import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadUtil readUtil = new ReadUtil();
        PrintUtil printUtil = new PrintUtil();

        List<MonthlyReport> monthlyReports = new ArrayList<>();
        YearlyReport yearlyReport = new YearlyReport(2021);

        boolean monthlyReportsIsRead = false;
        boolean yearlyReportsIsRead = false;

        while (true) {
            printUtil.printMenu();
            int command = scanner.nextByte();

            switch (command) {
                case 1: {
                    for (int i = 0; i < 3; i++) {
                        monthlyReports.add(new MonthlyReport(i + 1));
                        readUtil.readAndSaveMonthlyReport("resources/m.20210" + (i + 1)
                                + ".csv", monthlyReports.get(i));
                    }

                    System.out.println("Месячные отчёты посчитаны");
                    monthlyReportsIsRead = true;
                    break;
                }

                case 2: {
                    readUtil.readAndSaveYearlyReport("resources/y.2021.csv", yearlyReport);
                    System.out.println("Годовой отчёт посчитан");
                    yearlyReportsIsRead = true;
                    break;
                }

                case 3: {
                    if (yearlyReportsIsRead && monthlyReportsIsRead) {
                        printUtil.printDataReconciliation(monthlyReports, yearlyReport);
                    } else {
                        System.out.println("Для сверки отчётов необходимо для начала считать их (команды 1 и 2)");
                    }

                    break;
                }

                case 4: {
                    for (MonthlyReport month : monthlyReports) {
                        printUtil.printMonthlyReportInformation(month);
                    }

                    break;
                }

                case 5: {
                    printUtil.printYearlyReportInformation(yearlyReport);
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

