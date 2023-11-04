package me.guillaume.recruitment.tournament;

public class Warrior{
int hitPoints;
Weapon weapon;
Boolean hasArmor;
Shield shield;

    public Warrior() {
        this.hitPoints = 100;
        this.weapon = new Weapon();
        this.hasArmor = false;
        this.shield = null;
    }

    public Warrior(int hitPoints, Weapon weapon) {
        this.hitPoints = hitPoints;
        this.weapon = weapon;
        this.hasArmor = false;
        this.shield = null;
    }

    public Warrior(int i, Weapon greatSword, boolean b) {
        this.hitPoints = i;
        this.weapon = greatSword;
        this.hasArmor = b;
        this.shield = null;
    }

    public void engage(Warrior warior) {

        while (this.hitPoints > 0 && warior.hitPoints > 0) {
            warior.takeDamage( this.weapon,this.hasArmor);
            if (warior.hitPoints <= 0) break;
            this.takeDamage( warior.weapon,warior.hasArmor);
        }

    }

    private void takeDamage(Weapon weapon,boolean hasArmor) {
        int damagetaken = 0;
        int weaponDamage = weapon.calculateDamage();
        if (hasArmor) weaponDamage -= 1;
        if (this.hasArmor) {
            damagetaken = weaponDamage-3;
        } else if (this.shield != null && this.shield.tryToBlock(weapon)) {
            damagetaken = 0;
            if (this.shield.getDurability() == 0) this.shield = null;
        } else {
            damagetaken = weaponDamage;
        }
        if(damagetaken>this.hitPoints){
            this.hitPoints=0;
        }else {
            this.hitPoints -= damagetaken<0 ? 0 : damagetaken ;
        }
    }


    public int hitPoints() {
        return hitPoints;
    }

    public Warrior equip(String equipement) {
        if (equipement.equals("armor")) {
            this.hasArmor = true;
        } else if (equipement.equals("buckler")) {
            this.shield = new Shield();
        }
        return this;
    }
}
