import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/in.txt"));

        ArrayList<String> list = new ArrayList<String>();

        String line;

        while((line = br.readLine()) != null) {
            list.add(line);
        }

        Submarine submarine = new Submarine(list);
        System.out.println(submarine.calculatePartOne());
        System.out.println(submarine.calculatePartTwo('0', '1') * submarine.calculatePartTwo('1', '0'));

    }

}
