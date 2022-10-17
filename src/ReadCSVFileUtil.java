import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFileUtil {
    public void readAndSaveYearlyReport(String path, YearlyReport object) {
        String stringYearlyReport = readFileContentsOrNull(path);
        String[] lines = stringYearlyReport.split(System.lineSeparator());

        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");

            if (lineContents[2].equals("false")) {
                object.incomes.put(lineContents[0], Integer.parseInt(lineContents[1]));
            } else {
                object.expenses.put(lineContents[0], Integer.parseInt(lineContents[1]));
            }
        }
    }

    public void readAndSaveMonthlyReport(String path, MonthlyReport object) {
        String stringMonthlyReport = readFileContentsOrNull(path);
        String[] lines = stringMonthlyReport.split(System.lineSeparator());

        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");

            List<Integer> data = new ArrayList<>();
            data.add(Integer.parseInt(lineContents[2]));
            data.add(Integer.parseInt(lineContents[3]));

            if (lineContents[1].equals("false")) {
                object.incomes.put(lineContents[0], data);
            } else {
                object.expenses.put(lineContents[0], data);
            }
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
