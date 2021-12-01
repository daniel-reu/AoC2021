import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/in.txt"));

            List<Integer> inputs = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                inputs.add(Integer.valueOf(line));
            }

            Sonar sonar = new Sonar(inputs);
            sonar.calculateAmountOfMeasurements();
            System.out.println("Check every number by itself: " + sonar.getAmountMeasurements());
            sonar.calculateAmountOfMeasurementsThree();
            System.out.println("Check in packs of 3: " + sonar.getAmountMeasurements());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
