import java.util.ArrayList;
import java.util.List;

public class Submarine {

    private List<String> diagnosticReport;

    public Submarine(List<String> diagnosticReport) {
        this.diagnosticReport = diagnosticReport;
    }

    public Integer calculatePartOne() {

        diagnosticReport.forEach(System.out::println);

        Integer length = diagnosticReport.get(0).length();
        StringBuilder epsilon = new StringBuilder();
        StringBuilder gamma = new StringBuilder();

        //Iterate through the first, then second....
        for(int i = 0; i < length; i++) {
            int k = i;
            int countOne = (int) diagnosticReport.stream().filter(report -> report.charAt(k) == '1').count();
            int countZero = diagnosticReport.size() - countOne;

            if(countZero > countOne) {
                gamma.append("1");
                epsilon.append("0");
            } else {
                gamma.append("0");
                epsilon.append("1");
            }
        }
        return Integer.valueOf(gamma.toString(), 2) * Integer.valueOf(epsilon.toString(), 2);
    }

    public Integer calculatePartTwo(char value1, char value2) {

        List<String> tempReport = diagnosticReport;

        char mostCommonChar = '0';

        for (int i = 0; i < tempReport.get(0).length() && tempReport.size() > 1; i++) {
            int k = i;
            int countOne = (int) tempReport.stream().filter(report -> report.charAt(k) == '1').count();
            int countZero = tempReport.size() - countOne;

            if (countZero > countOne) {
                mostCommonChar = value1;
            } else {
                mostCommonChar = value2;
            }

            char expectedChar = mostCommonChar;
            tempReport = tempReport.stream().filter(report -> report.charAt(k) == expectedChar).toList();
        }
        return Integer.valueOf(tempReport.get(0), 2);
    }
}

