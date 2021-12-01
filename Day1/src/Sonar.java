import java.util.List;

public class Sonar {

    private List<Integer> measurements;

    private Integer amountMeasurements = 0;

    public Sonar(List<Integer> list) {
        this.measurements = list;
    }

    public void calculateAmountOfMeasurements() {
        amountMeasurements = 0;
        for(int i = 1; i < measurements.size(); i++) {
            //Set the current and previous index
            Integer current = i;
            Integer previous = i - 1;

            //Get the current and previous numbers out of the list
            Integer currentNum = measurements.get(current);
            Integer previousNum = measurements.get(previous);
            if(currentNum > previousNum) {
                amountMeasurements++;
            }
        }
    }

    public void calculateAmountOfMeasurementsThree() {
        amountMeasurements = 0;
        //We want to start at index 3 since we are looking at packs of 3 elements at a time
        for(int i = 3; i < measurements.size(); i++) {
            //Set the current and previous index
            Integer current = i;
            Integer previous = i -1;

            //Get and calculate the current and previous elements
            Integer currentNum = measurements.get(current) + measurements.get(current - 1) + measurements.get(current - 2);
            Integer previousNum = measurements.get(previous) + measurements.get(previous - 1) + measurements.get(previous - 2);
            if(currentNum > previousNum) {
                amountMeasurements++;
            }
        }
    }

    public Integer getAmountMeasurements() {
        return amountMeasurements;
    }
}
