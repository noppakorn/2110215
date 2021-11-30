package role.derived;

import game.logic.GameAction;
import game.logic.GameLogic;
import game.object.Card;
import role.base.PreTurnActable;
import role.base.Role;

public class Seer extends Role implements PreTurnActable {

    @Override
    public void preTurnActs(GameAction action) {
        Card c0 = (Card) (action.getInfo(0));
        Card c1 = (Card) (action.getInfo(1));
        GameLogic.getInstance().getCurrentRound().swapCards(c0, c1);
    }

    @Override
    public String toString() {
        return "Seer";
    }
}
