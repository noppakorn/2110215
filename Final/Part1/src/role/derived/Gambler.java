package role.derived;

import game.logic.GameAction;
import game.object.GameObject;
import game.object.Player;
import role.base.PreRoundActable;
import role.base.PreTurnActable;
import role.base.Role;

public class Gambler extends Role implements PreRoundActable, PreTurnActable {

    @Override
    public void preRoundActs(GameAction action) {
        for (int i = 0; i < action.length; ++i) {
            ((Player)action.getInfo(i)).setOrder(i);
        }
    }

    @Override
    public void preTurnActs(GameAction action) {
        for (int i = 0; i < action.length; ++i) {
            ((Player)action.getInfo(i)).setToBeSwapped(true);
        }
    }
    @Override
    public String toString() {
        return "Gambler";
    }

}
