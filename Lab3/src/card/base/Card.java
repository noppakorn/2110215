package card.base;

import java.util.Objects;

//You CAN modify the first line
public abstract class Card {
	private String name;
	private String description;

	public Card(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public abstract String toString();

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name);
	}

}
