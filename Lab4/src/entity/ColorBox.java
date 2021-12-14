package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.GameController;
import logic.Sprites;

public class ColorBox extends Entity implements Interactable {
    private boolean activeBool;
    public ColorBox (boolean activeBox) {
        activeBool = activeBox;
    }

    @Override
    public int getSymbol() {
        return activeBool ? Sprites.BOX_RED : Sprites.BOX_BLUE;
    }

    @Override
    public boolean interact(Entity e) {
        if (GameController.getGameSwitchStatus() == activeBool) {
            return move(e.getDirection());
        }
        return false;
    }
    public boolean getActiveBool() {
        return activeBool;
    }
    public void setActiveBool(boolean activeBool) {
        this.activeBool = activeBool;
    }
}
