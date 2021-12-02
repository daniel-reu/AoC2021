import java.util.List;

public class Submarine {
	
	protected Long horizontalPos = 0l;
	
	protected Long depthPos = 0l;
	
	public Submarine() {
		
	}
	
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
	
	public Long getResult() {
		return horizontalPos * depthPos;
	}
	
	public void moveForward(Integer amount) {
		horizontalPos += amount;
	}
	
	public void moveUp(Integer amount) {
		depthPos -= amount;
	}
	
	public void moveDown(Integer amount) {
		depthPos += amount;
	}

}
