package me.guillaume.recruitment.tournament;

public class Weapon {
    private String name;
    private int damage;

    private int maxAttacks;
    private int remainingAttacks;
    private int cooldown;
    private int cooldownCounter;

    public Weapon() {
        this.name = "sword";
        this.damage = 5;
        this.maxAttacks = 0;
        this.cooldown = 0;
        this.cooldownCounter = 0;
        this.remainingAttacks = 0;
    }

    public Weapon(String name, int damage, int maxAttacks, int cooldown) {

        this.name = name;
        this.damage = damage;
        this.maxAttacks = maxAttacks;
        this.remainingAttacks = maxAttacks;
        this.cooldown = cooldown;
        this.cooldownCounter = 0;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public int getMaxAttacks() {
        return maxAttacks;
    }

    public int getCooldown() {
        return cooldown;
    }

    public boolean canAttack() {
        return maxAttacks > 0 && cooldownCounter == 0;
    }
    public int calculateDamage(){
        if (canAttack()) {
            remainingAttacks--;
            if (remainingAttacks == 0) {
                cooldownCounter = cooldown;
                remainingAttacks = maxAttacks ; // Reset attacks
            }
            return this.damage;
        }
        else{
            cooldownCounter--;
            return 0;
        }
    }
}
