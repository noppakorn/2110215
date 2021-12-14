package solar;

public class Earth extends Planet {
	private int wasteLevel;

	public Earth(int orbitRadius, int wasteLevel) {
		super(orbitRadius);
		this.wasteLevel = Math.max(wasteLevel, 0);
	}

	public Earth() {
		super();
		wasteLevel = 0;
	}

	public int getWasteLevel() {
		return wasteLevel;
	}

	public boolean orbit() {
		if (wasteLevel <= 5) {
			return super.orbit();
		}
		return false;
	}

}
