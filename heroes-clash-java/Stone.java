package heroesClashGame;

public class Stone {
    private String name;
    private String ability;
    private int upgradePoints;

    public Stone(String name, String ability, int upgradePoints){
        this.name = name;
        this.ability = ability;
        this.upgradePoints = upgradePoints;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName (){
        return this.name;
    }

    public void setAbility (String ability){
        this.ability = ability;
    }

    public String getAbility (){
        return this.ability;
    }

    public void setUpgradePoints (int upgradePoints){
        this.upgradePoints = upgradePoints;
    }

    public int getUpgradePoints (){
        return this.upgradePoints;
    }
}
