package me.guillaume.recruitment.tournament;

public class Shield extends Equipement {
    private int durability;
    private boolean canBlock;

    public Shield() {
        super("buckler");
        this.durability = 3;
        this.canBlock = true;
    }

    public int getDurability() {
        return this.durability;
    }

    public void setDurability(int i) {
        this.durability = i;
    }


    public boolean tryToBlock(Weapon weapon) {
        if (this.canBlock) {
            if (this.durability > 0) {
                if(weapon.getName().equals("axe")) this.durability -= 1;
                this.canBlock = false;
                return true;
            }
        }
            this.canBlock = true;
            return false;
    }
}
