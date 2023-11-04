package me.guillaume.recruitment.tournament;

public class Viking extends Warrior {



    public Viking() {
        super(120,new Weapon("axe", 6, 1, 0),false);
    }


    public Viking equip(String equipement) {
        if (equipement.equals("armor")) {
            this.hasArmor = true;
        } else if (equipement.equals("buckler")) {
            this.shield = new Shield();
        }
        return this;
    }
}