package card.cards;

import card.base.CharacterCard;
import card.base.ItemCard;
import player.Player;

//You CAN modify the first line
public class ExodiaCharacterCard extends CharacterCard {

	public ExodiaCharacterCard() {
		super("Exodia the Forbidden One", "With 4 or more Exodia Part Card equiped, you win the game", 800, 0, 25);
	}

	// Fill Code Here
	public int sacrifice(Player player) {
		int heal = player.getMaxLifePoint() / 10;
		player.healPlayer(heal);
		return heal;
	}

	public boolean winConditionCheck(ItemCard[] inventory) {
		int count = 0;
		for (var c : inventory) {
			if (c instanceof ExodiaPartCard) {
				++count;
			}
		}
		return count == 4;
	}
}