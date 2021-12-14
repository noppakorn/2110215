package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.GameController;
import logic.Sprites;

public class Flag extends Entity implements Interactable {
    @Override
    public int getSymbol() {
        return Sprites.FLAG;
    }

    @Override
    public boolean interact(Entity e) {
        if (e instanceof Player) {
            GameController.setGameWin(true);
            return true;
        }
        return false;
    }
}
