package solar;

public class Saturn extends Planet {
	private int speed;

	public Saturn(int orbitRadius, int speed) {
		super(orbitRadius);
		this.speed = Math.max(speed, 0);
	}

	public Saturn() {
		super();
		this.speed = 0;
	}

	public int getSpeed() {
		return speed;
	}

	public boolean orbit() {
		if (speed > 0) {
			for (int i = 0; i < speed; ++i) {
				if (!super.orbit()) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
