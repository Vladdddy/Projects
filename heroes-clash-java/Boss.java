package heroesClashGame;

public class Boss extends Character{
    private final String newSpecialAbility;

    public Boss(String name, double life, int damage, int armor, String specialAbility, boolean isAlive, String newSpecialAbility) {
        super(name, life, damage, armor, specialAbility, isAlive);
        this.newSpecialAbility = newSpecialAbility;
    }

    public String getNewSpecialAbility(){
        return this.newSpecialAbility;
    }
}
