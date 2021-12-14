package card.cards;

import player.Player;
import card.base.ItemCard;

//You CAN modify the first line
public class ExodiaPartCard extends ItemCard {

	public ExodiaPartCard(String name, int defense) {
		super(name, "Assemble 4 of Exodia part card to win the game", 0, 0, defense);
	}

	public void equipItem(Player player) {
		player.addInventory(this);
		int multiplier = player.getAssignedCharacter() instanceof ExodiaCharacterCard ? 2 : 1;
		player.setDefense(player.getDefense() + defenseBonus * multiplier);
	}

}