package heroesClashGame;

public class Player {
    private String nickname;
    private Stone stone;
    private Character hero;

    public Player(String nickname, Stone stone, Character hero){
        this.nickname = nickname;
        this.stone = stone;
        this.hero = hero;
    }

    public void setNickname (String nickname){
        this.nickname = nickname;
    }

    public String getNickname (){
        return this.nickname;
    }

    public void setPlayersStone (Stone stone){
        this.stone = stone;
    }

    public Stone getPlayersStone (){
        return this.stone;
    }

    public void setPlayersHero (Character hero){
        this.hero = hero;
    }

    public Character getPlayersHero (){
        return this.hero;
    }
}
