package kai.hexagon;

import java.util.ArrayList;

public class Coordinate {

	public static final int DIRECT_X = 0;
	public static final int DIRECT_Y = 1;
	public static final int DIRECT_Z = 2;

	private int x;

	private int y;

	private int z;

	public Coordinate(int x, int y, int z) throws Exception {
		if (x + y + z != 0) {
			throw new IllegalArgumentException("three directions sum value must equal to zero");
		}

		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	@Override
	public String toString() {
		return x + ":" + y + ":" + z;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Coordinate) {
			Coordinate coordinate = (Coordinate) o;
			return x == coordinate.x && y == coordinate.y && z == coordinate.z;
		}

		return false;
	}

	public static int getDirectDistance(Coordinate a, Coordinate b, int direct) {
		switch (direct) {
		case DIRECT_X:
			return Math.abs(a.getX() - b.getX());
		case DIRECT_Y:
			return Math.abs(a.getY() - b.getY());
		case DIRECT_Z:
			return Math.abs(a.getZ() - b.getZ());
		default:
			return -1;
		}
	}

	public static boolean isNeighbors(Coordinate a, Coordinate b) {
		if (getDirectDistance(a, b, DIRECT_X) != 1) {
			return false;
		}
		if (getDirectDistance(a, b, DIRECT_Y) != 1) {
			return false;
		}
		if (getDirectDistance(a, b, DIRECT_Z) != 1) {
			return false;
		}

		return true;
	}

	public static int getDistance(Coordinate a, Coordinate b) {
		return (getDirectDistance(a, b, DIRECT_X) +
				getDirectDistance(a, b, DIRECT_Y) +
				getDirectDistance(a, b, DIRECT_Z))
				/ 2;
//		int dX = getDirectDistance(a, b, DIRECT_X);
//		int dY = getDirectDistance(a, b, DIRECT_Y);
//		int dZ = getDirectDistance(a, b, DIRECT_Z);
//		return Math.max(Math.max(dX, dY), dZ);
	}

	public static ArrayList<Coordinate> getAreaByCenter(Coordinate center, int radius) {
		ArrayList<Coordinate> area = new ArrayList<>();

		if (radius < 0) {
			return area;
		}

		int offsetX = 0;
		int offsetY = 0;
		int offsetZ = 0;

		if (center != null) {
			offsetX = center.getX();
			offsetY = center.getY();
			offsetZ = center.getZ();
		}

		for (int x = offsetX - radius; x <= offsetX + radius; x++) {
			for (int y = offsetY - radius; y <= offsetY + radius; y++) {
				for (int z = offsetZ - radius; z <= offsetZ + radius; z++) {
					try {
						Coordinate coordinate = new Coordinate(x, y, z);
						area.add(coordinate);
					} catch (Exception e) {
						continue;
					}
				}
			}
		}

		return area;
	}

}
