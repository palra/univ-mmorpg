package fr.univdevs.mmorpg.game.character;

import fr.univdevs.mmorpg.engine.Player;
import fr.univdevs.mmorpg.engine.character.*;
import fr.univdevs.mmorpg.engine.character.Character;
import fr.univdevs.mmorpg.engine.character.item.Weapon;
import fr.univdevs.mmorpg.engine.character.skills.CanCure;
import fr.univdevs.mmorpg.engine.character.skills.CanFight;
import fr.univdevs.mmorpg.game.action.FightAction;
import fr.univdevs.util.Vector2D;

/**
 * Created by drattak on 23/05/15.
 * TODO : document
 */
public class Warrior extends Character implements CanFight {
    private String[] canUse = {"Knife", "Bow", "Sword", "HyperPotion", "Potion", "SuperPotion"};

    /**
     * Warrior constructor
     * A warrior is a Character that can use any type of weapon
     *
     * @param name the name of the warrior
     */
    public Warrior(String name, Player chosenPlayer) {
        super(name, "Warrior", chosenPlayer);
    }

    public Warrior(String name) {
        super(name, "Warrior");
    }

    @Override
    public String[] getCanUse() {
        return canUse;
    }

    public String getDisplay() {
        return null;
    }

    public boolean isCollidable() {
        return true;
    }

    public Vector2D getPosition() {
        return null;
    }

    public void cure(Character target, String cureName) {

    }

    public void attack(Character target, String weaponName) {
        if (this.getInventory().getItemByCategory(weaponName) instanceof Weapon) {
            FightAction fa = new FightAction(this.getPlayer(), target.getPlayer(), (Weapon) this.getInventory().getItemByCategory(weaponName));
        }
    }

}
