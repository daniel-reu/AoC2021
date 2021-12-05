import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HydrothermalVents {

    private static final Integer MAPSIZE = 1000;
//    private static final Integer MAPSIZE = 10;

    private Integer[][] mapOfHydrothermalVents;

    public HydrothermalVents() {
        this.mapOfHydrothermalVents = new Integer[MAPSIZE][MAPSIZE];
        initializeMap();
    }

    public void setVentsOnMap(@NotNull List<Vent> vents) {
        Vent start = vents.get(0);
        Vent end = vents.get(1);

        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        //We are drawing a horizontal line
        if(startX == endX) {
            Integer lowY = Math.min(startY, endY);
            Integer highY = Math.max(startY, endY);
            for(int i = lowY; i <= highY; i++) {
                mapOfHydrothermalVents[i][startX]++;
            }
        //We are drawing a vertical line
        } else if(startY == endY) {
            Integer lowX = Math.min(startX, endX);
            Integer highX = Math.max(startX, endX);
            for(int i = lowX; i <= highX; i++) {
                mapOfHydrothermalVents[startY][i]++;
            }
        } else {
            int direction = (endY - startY) / (endX - startX);
            if(direction == 1) {
                if(startX < endX) {
                    Integer y = startY;
                    for(int i = startX; i <= endX; i++) {
                        mapOfHydrothermalVents[y][i]++;
                        y++;
                    }
                } else if(endX < startX) {
                    Integer y = endY;
                    for(int i = endX; i <= startX; i++) {
                        mapOfHydrothermalVents[y][i]++;
                        y++;
                    }
                }
            } else if(direction == -1) {
                if(startX < endX) {
                    Integer y = startY;
                    for (int i = startX; i <= endX; i++) {
                        mapOfHydrothermalVents[y][i]++;
                        y--;
                    }
                } else if(endX < startX) {
                    Integer y = endY;
                    for (int i = endX; i <= startX; i++) {
                        mapOfHydrothermalVents[y][i]++;
                        y--;
                    }
                }
            }
        }
    }

    public Integer getAmountOfOverlap() {
        Integer result = 0;
        for (int i = 0; i < MAPSIZE; i++) {
            for (int j = 0; j < MAPSIZE; j++) {
                if(mapOfHydrothermalVents[i][j] >= 2) {
                    result++;
                }
            }
        }
        return result;
    }

    public void addVents(@NotNull String line) {
        String[] points = line.split(" -> ");
        String[] startPoint = points[0].split(",");
        String[] endPoint = points[1].split(",");
        setVentsOnMap(List.of(new Vent(Integer.valueOf(startPoint[0]), Integer.valueOf(startPoint[1])),
                new Vent(Integer.valueOf(endPoint[0]), Integer.valueOf(endPoint[1]))));
    }

    private void initializeMap() {
        for (int i = 0; i < MAPSIZE; i++) {
            for (int j = 0; j < MAPSIZE; j++) {
                mapOfHydrothermalVents[i][j] = 0;
            }
        }
    }
}
