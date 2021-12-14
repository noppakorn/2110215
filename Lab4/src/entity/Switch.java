package entity;

import entity.base.Entity;
import entity.base.Interactable;
import entity.base.Updatable;
import exception.IllegalValueException;
import logic.GameController;
import logic.Sprites;

public class Switch extends Entity implements Interactable, Updatable {
    private boolean isActive;

    public Switch() {
        isActive = GameController.getGameSwitchStatus();
    }

    @Override
    public int getSymbol() {
        return isActive ? Sprites.SWITCH_ON : Sprites.SWITCH_OFF;
    }

    @Override
    public boolean interact(Entity e) {
        if (e instanceof Player) {
            GameController.setGameSwitchStatus(!GameController.getGameSwitchStatus());
        }
        return false;
    }

    @Override
    public void update() {
        isActive = GameController.getGameSwitchStatus();
    }

    @Override
    public void valueCorrection() {

    }
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
