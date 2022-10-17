import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadCSVFileUtil readUtil = new ReadCSVFileUtil();

        YearlyReport yearlyReport = new YearlyReport();
        List<MonthlyReport> monthlyReports = new ArrayList<>();

        while (true) {
            printMenu();
            int command = scanner.nextByte();

            switch (command) {
                case 1: {
                    for (int i = 0; i < 3; i++) {
                        monthlyReports.add(new MonthlyReport());
                        readUtil.readAndSaveMonthlyReport("resources/m.20210" + (i + 1) + ".csv", monthlyReports.get(i));
                        System.out.println(monthlyReports.get(i));
                    }

                    break;
                }
                case 2: {
                    readUtil.readAndSaveYearlyReport("resources/y.2021.csv", yearlyReport);
                    System.out.println(yearlyReport);
                    break;
                }
                case 3: {}
                case 4: {}
                case 5: {}
                case 111: return;
                default: System.out.println("Извините, такой команды нет, попробуйте снова");
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

