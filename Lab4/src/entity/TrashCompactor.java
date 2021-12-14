package entity;

import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Interactable;
import entity.base.Updatable;
import exception.IllegalValueException;
import logic.GameController;
import logic.Sprites;

public class TrashCompactor extends Entity implements Interactable, Consumable, Updatable {
    private int cooldown;

    public TrashCompactor() {
        cooldown = 0;
    }

    @Override
    public int getSymbol() {
        return cooldown == 0 ? Sprites.COMPACTOR_ON : Sprites.COMPACTOR_OFF;
    }

    @Override
    public boolean interact(Entity e) {
        return Entity.isBox(e) && cooldown == 0;
    }


    @Override
    public boolean consume(Entity e) {
        if (Entity.isBox(e) && cooldown == 0) {
            cooldown = GameController.MAX_COOLDOWN_TIME;
            return true;
        }
        return false;
    }


    @Override
    public void update() throws IllegalValueException {
        if (cooldown < 0) {
            throw new IllegalValueException();
        } else if (cooldown > 0) {
            --cooldown;
        }
    }

    @Override
    public void valueCorrection() {
        cooldown = 0;

    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
}
