import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("src/in.txt"));
		
		ArrayList<String> lines = new ArrayList<String>();
		
		String line;
		
		while((line = br.readLine()) != null) {
			lines.add(line);
		}
		
		Submarine submarine = new Submarine();
		submarine.calculate(lines);
		
		System.out.println("Normal Submarine: " + submarine.getResult());
		
		AimingSubmarine aimingSubmarine = new AimingSubmarine();
		aimingSubmarine.calculate(lines);
		
		System.out.println("Aiming Submarine: " + aimingSubmarine.getResult());
		
	}

}
