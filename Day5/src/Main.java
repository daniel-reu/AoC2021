import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/in.txt"));

        String line;

        ArrayList<String> input = new ArrayList<String>();

        HydrothermalVents hydrothermalVents = new HydrothermalVents();
        while((line = br.readLine()) != null) {
            hydrothermalVents.addVents(line);
        }
        System.out.println(hydrothermalVents.getAmountOfOverlap());
    }

}
