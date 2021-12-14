package solar;

public class Planet {
	protected Coordinate coordinate;
	protected Coordinate orbitCenterCoordinate;
	protected int orbitRadius;

	public Planet(int orbitRadius) {
		super();
		orbitRadius = Math.max(1, orbitRadius);
		this.coordinate = new Coordinate(orbitRadius, 0);
		this.orbitCenterCoordinate = new Coordinate();
		this.orbitRadius = orbitRadius;
	}

	public Planet() {
		this(1);
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Coordinate getOrbitCenterCoordinate() {
		return orbitCenterCoordinate;
	}

	public int getOrbitRadius() {
		return orbitRadius;
	}

	public boolean orbit() {
		if (coordinate.getX() == orbitRadius && coordinate.getY() == 0) {
			coordinate.setX(0);
			coordinate.setY(-orbitRadius);
		} else if (coordinate.getX() == 0 && coordinate.getY() == -orbitRadius) {
			coordinate.setX(-orbitRadius);
			coordinate.setY(0);
		} else if (coordinate.getX() == -orbitRadius && coordinate.getY() == 0) {
			coordinate.setX(0);
			coordinate.setY(orbitRadius);
		} else if (coordinate.getX() == 0 && coordinate.getY() == orbitRadius) {
			coordinate.setX(orbitRadius);
			coordinate.setY(0);
		} else {
			return false;
		}
		return true;
	}

}
