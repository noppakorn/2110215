package deck;

import java.util.Arrays;

import card.base.Card;

public class Deck {
	// TODO: constructor
	private String name;
	private int deckSize;
	private Card[] deckList;

	public Deck(String name, Card[] deckList) {
		this.name = name;
		this.deckSize = deckList.length;
		this.deckList = deckList;
	}

	// You CAN modify the first line
	public int insertCard(Card card) throws InsertCardFailedException {
		int count = 0;
		for (int i = 0; i < deckSize; ++i) {
			if (deckList[i].equals(card)) {
				++count;
			}
		}
		if (count >= 4)
			throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
		// FILL CODE HERE
		// You can use Arrays.copyOf(Original Array, New Length) to create new arrays
		// with bigger size
		// Must return new deckSize
		Card[] tmpDeckList = Arrays.copyOf(deckList, deckSize + 1);
		tmpDeckList[deckSize] = card;
		deckList = tmpDeckList;
		return ++deckSize;
	}

	// You CAN modify the first line
	public Card removeCard(int slotNumber) throws RemoveCardFailedException {
		if (this.deckList.length <= slotNumber) {
			throw new RemoveCardFailedException("Number you insert exceed deck size");
		}
		if (this.deckList[slotNumber] == null) {
			throw new RemoveCardFailedException("There is no card in that slot");
		}
		// FILL CODE HERE
		// You can use Arrays.copyOf(Original Array, New Length) to create new arrays
		// with bigger size
		// Once card is removed, other card down the list must rearrange to the empty
		// slot
		// Must return card that was removed
		Card[] tmpDeckList = new Card[--deckSize];
		Card removedCard = deckList[slotNumber];
		int removed = 0;
		for (int i = 0; i < deckList.length; ++i) {
			if (i == slotNumber) {
				++removed;
			} else {
				tmpDeckList[i - removed] = deckList[i];
			}
		}
		deckList = tmpDeckList;
		return removedCard;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("{").append(this.getName()).append("}").append("(").append(this.getDeckSize())
				.append(" deck size)").toString();
	}

	/* GETTERS & SETTERS */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeckSize() {
		return deckSize;
	}

	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
	}

	public Card[] getDeckList() {
		return deckList;
	}

	public void setDeckList(Card[] deckList) {
		this.deckList = deckList;
	}
}
