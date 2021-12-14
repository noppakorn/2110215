package card.cards;

import card.base.CharacterCard;
import player.Player;

//You CAN modify the first line
public class MainCharacterCard extends CharacterCard {
	private int level;
	private float levelUpBonus;

	public MainCharacterCard(String name, String description, int lifePoint, int attackPoint, int defensePoint,
			float levelUpBonus) {
		super(name, description, lifePoint, attackPoint, defensePoint);
		this.level = 0;
		this.levelUpBonus = levelUpBonus;
	}

	public int sacrifice(Player player) {
		int heal = player.getMaxLifePoint() / 8;
		player.healPlayer(heal);
		return heal;
	}

	private int levelUpByBonus(int currentPoint) {
		return (int) (currentPoint * (1 + this.levelUpBonus));
	}

	public float levelUp(Player player) {
		++level;
		player.setNewCharacterLifePoint(levelUpByBonus(player.getCurrentLifePoint()));
		player.setAttack(levelUpByBonus(player.getAttack()));
		player.setDefense(levelUpByBonus(player.getDefense()));
		return levelUpBonus;
	}

	@Override
	public String getName() {
		return super.getName() + " [level " + this.getLevel() + "]";
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
