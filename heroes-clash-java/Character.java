package heroesClashGame;

public class Character {
    protected String name;
    protected double life;
    protected int damage;
    protected int armor;
    protected String specialAbility;
    protected boolean isAlive;
    protected final String RED = "\u001B[31m";
    protected final String RESET = "\u001B[0m";
    protected final String CYAN = "\u001B[36m";
    protected final String YELLOW = "\u001B[33m";

    public Character(String name, double life, int damage, int armor, String specialAbility, boolean isAlive){
        this.name = name;
        this.life = life;
        this.damage = damage;
        this.armor = armor;
        this.specialAbility = specialAbility;
        this.isAlive = isAlive;
    }

    public String getName() {
        return this.name;
    }

    public void setLife(double life) {
        if (!(life < 500)){
            this.life = 500;
        } else {
            this.life = life;
        }
    }

    public double getLife() {
        return this.life;
    }

    public void setDamage(int damage) {
        if (!(damage < 100)){
            this.damage = 100;
        } else {
            this.damage = damage;
        }
    }

    public int getDamage() {
        return this.damage;
    }

    public void setArmor(int armor) {
        if (!(armor < 100)){
            this.armor = 100;
        } else if (armor < 1){
            this.armor = 1;
        } else {
            this.armor = armor;
        }
    }

    public int getArmor() {
        return this.armor;
    }

    public String getSpecialAbility() {
        return this.specialAbility;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public String getStats(){
        return this.name + RED + "\n❤️Life: "+ (int)this.life + RESET + "\n⚔️Damage: " + this.damage + CYAN + "\n🛡️Armor: " + this.armor + RESET + YELLOW + "\n⭐Special Ability: " + this.specialAbility + RESET;
    }
}