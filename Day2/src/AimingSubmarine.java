import java.util.List;

public class AimingSubmarine extends Submarine {

	private Long aim = 0l;
	
	public AimingSubmarine() {
		super();
	}
	
	@Override
	public void calculate(List<String> list) {
		for(String s : list) {
			String[] arrayList = s.split(" ");
			
			switch (arrayList[0]) {
			case "forward":
				moveForward(Integer.valueOf(arrayList[1]));
				break;
			case "up":
				moveUp(Integer.valueOf(arrayList[1]));
				break;
			case "down":
				moveDown(Integer.valueOf(arrayList[1]));
				break;
			default:
				break;
			}
		}
	}
	
	@Override
	public void moveUp(Integer amount) {
		aim -= amount;
	}

	@Override
	public void moveDown(Integer amount) {
		aim += amount;
	}

	@Override
	public void moveForward(Integer amount) {
		horizontalPos += amount;
		depthPos += aim * amount;
	}
	
}
