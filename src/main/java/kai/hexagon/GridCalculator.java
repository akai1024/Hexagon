package kai.hexagon;

import java.util.ArrayList;
import java.util.Random;

public class GridCalculator {

	public static void main(String[] args) {
		ArrayList<Coordinate> grid = createGrid(1);

		System.out.println(grid);
		System.out.println(grid.size());

		Random rnd = new Random();

		Coordinate a = grid.get(rnd.nextInt(grid.size()));
		Coordinate b = grid.get(rnd.nextInt(grid.size()));
		System.out.println(a + " and " + b + " isNeighbors=" + Coordinate.isNeighbors(a, b));
		System.out.println(a + " and " + b + " distance=" + Coordinate.getDistance(a, b));
	}

	public static ArrayList<Coordinate> createGrid(int radius) {
		
		Coordinate center = null;
		try {
			center = new Coordinate(1, 0, -1);
		} catch (Exception e) {
			
		}
		return Coordinate.getAreaByCenter(center, radius);
	}



}
