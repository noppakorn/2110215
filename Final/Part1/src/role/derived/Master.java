package role.derived;

import game.logic.GameAction;
import game.object.Card;
import game.object.GameObject;
import role.base.PreRoundActable;
import role.base.Role;

public class Master extends Role implements PreRoundActable {
    @Override
    public void preRoundActs(GameAction action) {
//        int i = 0;
//        for (GameObject a : action.getInfo()) {
//            if (a instanceof Card) {
//                ((Card)a).setSlot(i++);
//            }
//        }
        for (int i = 0; i < action.length; ++i) {
            ((Card)action.getInfo(i)).setSlot(i);
        }
    }

    @Override
    public String toString() {
        return "Master";
    }
}
