import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadUtil {
    Logic logic = new Logic();

    public void readAndSaveMonthlyReports(List<MonthlyReport> monthlyReports) {
        for (int i = 0; i < 3; i++) {
            String path;

            if (i > 8) {
                path = "resources/m.2021" + (i + 1) + ".csv";
            } else {
                path = "resources/m.20210" + (i + 1) + ".csv";
            }

            monthlyReports.add(new MonthlyReport(i + 1));
            readAndSaveMonthlyReport(path, monthlyReports.get(i));
        }
    }

    public void readAndSaveYearlyReport(String path, YearlyReport yearlyReport) {
        String stringYearlyReport = readFileContentsOrNull(path);
        String[] lines = stringYearlyReport.split(System.lineSeparator());

        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");

            if (lineContents[2].equals("false")) {
                yearlyReport.incomes.put(lineContents[0], Integer.parseInt(lineContents[1]));
            } else {
                yearlyReport.expenses.put(lineContents[0], Integer.parseInt(lineContents[1]));
            }
        }
    }

    public void readAndSaveMonthlyReport(String path, MonthlyReport monthlyReport) {
        String stringMonthlyReport = readFileContentsOrNull(path);
        String[] lines = stringMonthlyReport.split(System.lineSeparator());

        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");

            MonthIncomesAndExpenses month = new MonthIncomesAndExpenses(
                    lineContents[0],
                    Boolean.parseBoolean(lineContents[1]),
                    Integer.parseInt(lineContents[2]),
                    Integer.parseInt(lineContents[3])
            );

            monthlyReport.incomesAndExpenses.add(month);
        }
    }

    public String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}
