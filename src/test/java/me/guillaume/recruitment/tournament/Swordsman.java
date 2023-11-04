package me.guillaume.recruitment.tournament;

public class Swordsman extends Warrior {
    public Swordsman() {
        super(100,new Weapon("sword",5,1,0),false);
    }
    public Swordsman equip(String equipement) {
        if (equipement.equals("armor")) {
            this.hasArmor = true;
        } else if (equipement.equals("buckler")) {
            this.shield = new Shield();
        }
        return this;

    }
}
