package heroesClashGame;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Colors
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";
        final String PURPLE = "\u001B[35m";
        final String CYAN = "\u001B[36m";
        final String ORANGE = "\u001B[38;2;255;165;0m";

        //Variables
        Scanner input = new Scanner(System.in);
        long currentTime = System.currentTimeMillis(); //Random
        int heroSelection = 0;
        boolean exit = false;

        //Abilities initialization
        String ability[] = {
                "Fire", "Ice", "Earth", "Moon",
                "Water", "Blood", "Abyss", "Diamond",
                "Sand", "Mist", "Shadow", "Thunder"
        };

        //Stones initialization
        Stone stonesList[] = {
                new Stone("Inferno Shard", ability[0], 17),
                new Stone("Frostheart Crystal", ability[1], 10),
                new Stone("Terra Relic", ability[2], 17),
                new Stone("Dragon’s Scale", ability[0], 20),
                new Stone("Oblivion Pebble", ability[6], 16),
                new Stone("Hero’s Relic", ability[4], 12),
                new Stone("Champion’s Core", ability[2], 22),
                new Stone("Bloodstone", ability[5], 33)
        };

        //Heroes initialization
        Character heroesList[] = {
                new Character("Aric Lionheart", 110, 25, 12, ability[0], true),
                new Character(CYAN + "Sir Darius Stormblade" + RESET, 220, 29, 10, ability[4], true),
                new Character(PURPLE + "Garrick Fireblade" + RESET, 250, 30, 15, ability[2], true),
                new Character("Eldrin Moonwhisper", 290, 19, 8, ability[3], true),
                new Character("Magnus Voidcaller", 90, 11, 9, ability[9], true),
                new Character(PURPLE + "Vespera Dawnfire" + RESET, 234, 28, 15, ability[0], true),
                new Character(PURPLE + "Nyx Moonblade" + RESET, 310, 36, 13, ability[3], true),
                new Character(ORANGE + "Deathrider" + RESET, 340, 41, 22, ability[5], true)
        };

        //Bosses initialization
        Boss bossesList[] = {
                new Boss(RED + "Malzor the Shadow King" + RESET, 600, 55, 32, ability[10], true, "Roaring Blust"),
                new Boss(RED + "Zeraphon, God of Chaos" + RESET, 450, 33, 26, ability[11], true, "Axe of Execution"),
                new Boss(RED + "Abyssus, Devourer of Realms" + RESET, 515, 39, 29, ability[6], true, "Abyss Expellion"),
                new Boss(RED + "Balakar Flamewrought" + RESET, 415, 24, 13, ability[0], true, "Flames Thrower"),
                new Boss(RED + "Gorath the Earthshaker" + RESET, 615, 31, 31, ability[2], true, "Earthquake")
        };

        /*
        for (Character i: heroesList){
            System.out.println(i.getStats() + "\n");
        }
        for (Boss i: bossesList){
            System.out.println(i.getStats() + "\n" + "🖤Second Special Ability: " + i.getNewSpecialAbility() + "\n");
        }
        */

        //Nickname
        System.out.print("Choose a nickname\n-> ");
        String nickname = input.nextLine();

        System.out.println(GREEN + "\n🌲 You wander into a shadowy forest, the air thick with tension and mystery..." + RESET);
        pauseStory(2);
        System.out.println(GREEN + "🔥 In the clearing ahead, " + heroesList.length + " brave heroes are locked in a fierce battle against a colossal boss!" + RESET);
        pauseStory(2);
        System.out.println(YELLOW + "🎲 Destiny calls! Roll the dice to determine which hero will join forces with you on this perilous journey." + RESET);
        pauseStory(2);
        System.out.println(YELLOW + "🤝 Will they become your trusted ally, or will fate lead you astray?\n" + RESET);
        pauseStory(2);

        //Assigning a hero to the player
        do {
            try {
                System.out.print("Choose a number from 1 to " + heroesList.length + "\n-> ");
                heroSelection = input.nextInt() - 1;
            } catch (Exception e){
                System.out.println(RED + "Invalid input, try again" + RESET);
                input.nextLine();
                heroSelection = -1;
                continue;
            }
        } while (heroSelection < 0 || heroSelection >= heroesList.length);

        //Random hero
        int randomHero = ThreadLocalRandom.current().nextInt(1,heroesList.length);
        System.out.println(PURPLE + "\nThis is the hero that you got:\n" + RESET);
        pauseStory(2);
        System.out.println(heroesList[randomHero].getStats());
        pauseStory(1);

        //Random stone
        int randomStone = ThreadLocalRandom.current().nextInt(1,stonesList.length);
        ArrayList <Stone> playersStone = new ArrayList <> ();

        playersStone.add(stonesList[randomStone]);

        System.out.println(CYAN + "\nYou also found a rare shiny stone: \n\n🪨"  + RESET + playersStone.getLast().getName() +
                " — [" + playersStone.getLast().getAbility() + "]");
        pauseStory(1);

        Player player = new Player(nickname, playersStone.getLast(), heroesList[randomHero]);

        while (!exit){
            int pathSelection = 0;

            //Path selection
            do {
                try {
                    System.out.println(ORANGE + "\n1.⚔️ Face the mighty Boss and test your strength!" + RESET);
                    System.out.println(CYAN + "2.🤺 Duel another player to prove your dominance!" + RESET);
                    System.out.println(PURPLE + "3.🛡️ Upgrade your hero to become unstoppable!" + RESET);
                    System.out.println(GREEN + "4.👹 Defend the lands against a horde of goblins!" + RESET);
                    System.out.println("5.🧾 View your player's stats!");
                    System.out.println("6. 💎 See your collected stones!");
                    System.out.println(RED + "7.❌ Quit the game!" + RESET);
                    System.out.print("-> ");

                    pathSelection = input.nextInt();
                } catch (Exception e){
                    System.out.println("Invalid input, try again");
                    input.nextLine();
                    pathSelection = -1;
                    continue;
                }
            } while (pathSelection < 1 || pathSelection > 7);

            switch (pathSelection){
                case 1:
                    Stone prizeStone = bossFight(player, bossesList, ability);

                    if (!(prizeStone == null)) {
                        playersStone.add(prizeStone);

                        System.out.println("You won a precious stone: \n\n🪨" + prizeStone.getName() +
                                " — [" + prizeStone.getAbility() + "]");

                        player.setPlayersStone(prizeStone);
                    } else {
                        if (!player.getPlayersHero().getIsAlive()){
                            int k = 0;
                            boolean heroesAlive = true;
                            System.out.println("\nLooks like your current hero has fallen... Let's look for another one");

                            //Check if the hero is alive
                            do{
                                randomHero = ThreadLocalRandom.current().nextInt(1,heroesList.length);
                                player.setPlayersHero(heroesList[randomHero]);

                                if(k == heroesList.length + 1){
                                    exit = true;
                                    heroesAlive = false;
                                    break;
                                }

                                k += 1;
                            } while (!player.getPlayersHero().getIsAlive());

                            if (heroesAlive) {
                                for (int i = 0; i < 3; i += 1){
                                    System.out.println("\n...");
                                    pauseStory(1);
                                }

                                pauseStory(1);
                                System.out.println(GREEN + "\n⚔️ Your fallen hero has been replaced! Meet your new champion:\n\n" + RESET + player.getPlayersHero().getStats());
                            } else {
                                System.out.println(RED + "\n💀 Oh no! All the heroes have fallen in battle! The realm is lost... Game over. ⚔️" + RESET);
                            }
                        }
                    }

                break;
                case 2: duelPlayers(player, heroesList, stonesList); break;
                case 3: upgradeHero(player, stonesList, playersStone); break;
                case 4: goblinFight(); break;
                case 5:
                    System.out.println("\n[Stats]\n" + player.getPlayersHero().getStats()); break;
                case 6:
                    if (!playersStone.isEmpty()){
                        for (Stone stone: playersStone) {
                            System.out.println("\n🪨" + stone.getName() + " — [" + stone.getAbility() + "]");
                        }
                    } else {
                        System.out.println("\n🧐 Looks like you're out of stones! Time to gather more before your next challenge!");
                    }

                    break;
                case 7:
                    System.out.println(RED + "\n❌ You have chosen to quit the game. Farewell, brave warrior... Until we meet again!" + RESET);
                    exit = true;
                    break;
                default : exit = true;
            }
        }

        input.close();
    }

    public static Stone bossFight(Player player, Boss[] bosses, String[] ability) throws InterruptedException {
        //Colors
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";
        final String PURPLE = "\u001B[35m";
        final String CYAN = "\u001B[36m";
        final String ORANGE = "\u001B[38;2;255;165;0m";

        int firstTurn = ThreadLocalRandom.current().nextInt(1, 3);
        int bossSelection = 0;
        int i = 0;
        Boss currentBoss = bosses[bossSelection];
        boolean cicle = true;

        //Boss selected
        do {
            bossSelection = ThreadLocalRandom.current().nextInt(0, (bosses.length));
            currentBoss = bosses[bossSelection];

            if(i == bosses.length + 1){
                System.out.println(GREEN + "\n🎉 Victory! All bosses have been defeated! The realm is safe... for now. 🌟" + RESET);
                return null;
            }

            i += 1;
        } while(!currentBoss.getIsAlive());

        if (!player.getPlayersHero().getIsAlive()){
            System.out.println(RED + "\n💀 You cannot fight – your hero has fallen! Their journey ends here..." + RESET);
            return null;
        }

        System.out.println("\n🎲 A dice is being rolled. It will determine on who will be claiming the first turn...");
        pauseStory(2);

        if (firstTurn == 1) {
            System.out.println(GREEN + "🎲 The dice has spoken! The first turn goes to:\n\n" + RESET +
                    "[" + player.getPlayersHero().getName() + "]");
        } else {
            System.out.println(RED + "🎲 Oh oh! The first hit if from:\n\n" + RESET +
                    "[BOSS] [" + currentBoss.getName() + "]");
        }

        pauseStory(2);

        while (cicle){
            if (firstTurn == 1){
                System.out.println("\n\n\n\n🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩\n");
                System.out.println("❤️" + RED + ((int)player.getPlayersHero().getLife()) + RESET +
                        " [" + player.getPlayersHero().getName() +
                        "] 🛡️" + CYAN + player.getPlayersHero().getArmor() + RESET);

                int damage = player.getPlayersHero().getDamage();
                int critDamage = ThreadLocalRandom.current().nextInt(1, 11);
                damage = damage - (player.getPlayersHero().getDamage() * currentBoss.getArmor()) / 100;

                if (critDamage == 5) {
                    damage = damage * (ThreadLocalRandom.current().nextInt(5, 11));
                    System.out.print(ORANGE + "🔥Enhanced Damage [" + player.getPlayersHero().getSpecialAbility() + "]" + RESET);
                    currentBoss.setArmor(currentBoss.getArmor() - ThreadLocalRandom.current().nextInt(4, 9));
                }

                critDamage = 0;

                double newLife = currentBoss.getLife() - damage;
                currentBoss.setLife(newLife);

                System.out.println(" -> ⚔️" + (int) damage);
                System.out.println("\n🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩\n");

                firstTurn += 1;
                Thread.sleep(1000);
            } else {
                System.out.println("\n\n\n\n🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥\n");
                System.out.println("❤️" + RED + ((int) currentBoss.getLife()) + RESET +
                        " [BOSS] [" + currentBoss.getName() +
                        "] 🛡️" + CYAN + currentBoss.getArmor() + RESET);

                int damage = currentBoss.getDamage();
                int critDamage = ThreadLocalRandom.current().nextInt(1, 11);
                damage = damage - (currentBoss.getDamage() * player.getPlayersHero().getArmor()) / 100;

                if (critDamage == 5) {
                    damage = damage * (ThreadLocalRandom.current().nextInt(2, 4));
                    System.out.print(BLUE + "🌀[" + currentBoss.getNewSpecialAbility() + "]" + RESET);
                    player.getPlayersHero().setArmor(player.getPlayersHero().getArmor() - (ThreadLocalRandom.current().nextInt(1, 11)));
                }

                if (damage < 1){
                    damage = 1;
                }

                double newLife = player.getPlayersHero().getLife() - damage;
                player.getPlayersHero().setLife(newLife);

                System.out.println(" -> ⚔️" + (int) damage);
                System.out.println("\n🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥\n");

                firstTurn -= 1;
                Thread.sleep(1000);
            }

            if (currentBoss.getLife() <= 0){
                cicle = false;
                System.out.println(YELLOW + "🏆 Victory! The hero emerges triumphant, defeating their foe with unmatched courage and skill!" + RESET);
                currentBoss.setIsAlive(false);

                double bonusLife = ThreadLocalRandom.current().nextInt(45,95);
                int bonusDamage = ThreadLocalRandom.current().nextInt(11, 24);
                int bonusArmor = ThreadLocalRandom.current().nextInt(14, 19);

                player.getPlayersHero().setLife(player.getPlayersHero().getLife() + bonusLife);
                player.getPlayersHero().setDamage(player.getPlayersHero().getDamage() + bonusDamage);
                player.getPlayersHero().setArmor(player.getPlayersHero().getArmor() + bonusArmor);

                System.out.println(PURPLE + "\n✨ Your hero has leveled up!\n" + RESET +
                        "[New Stats]\n\n" +
                        player.getPlayersHero().getStats() + "\n");

                pauseStory(1);

                int randomPrizeStone = ThreadLocalRandom.current().nextInt(0, ability.length);
                int randomValue = ThreadLocalRandom.current().nextInt(22, 47);

                return new Stone("Inferno Shard", ability[randomPrizeStone], randomValue);
            } else if (player.getPlayersHero().getLife() <= 0){
                cicle = false;
                System.out.println(RED + "💀 Defeat... The boss stands victorious, its menacing roar echoing through the battlefield. Darkness falls..." + RESET);
                player.getPlayersHero().setIsAlive(false);
            }
        }

        return null;
    }

    public static void duelPlayers(Player player, Character[] heroesList, Stone[] stonesList){
        //Colors
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";

        String[] botNames = {
                "Ravenblade", "Shadowfang", "Duskweaver",
                "Stormchaser", "Zephyrstrike", "Drakonis",
                "Soulreaver", "Voidstalker", "Frostbane"
        };

        Player player2 = new Player(
                botNames[ThreadLocalRandom.current().nextInt(0, botNames.length)],
                stonesList[ThreadLocalRandom.current().nextInt(0, stonesList.length)],
                heroesList[ThreadLocalRandom.current().nextInt(0, heroesList.length)]
        );

        System.out.println("\n⚔️ Prepare yourself! You will be facing:");
        System.out.println("[Player] " + YELLOW + player2.getNickname() + RESET);
        System.out.println("\n" + player2.getPlayersHero().getStats());


        System.out.println("\nFunction is still being developed!");
    }

    public static void upgradeHero(Player player, Stone[] stonesList, ArrayList <Stone> playersStone) throws InterruptedException {
        try{
            //Colors
            final String RESET = "\u001B[0m";
            final String RED = "\u001B[31m";
            final String YELLOW = "\u001B[33m";
            final String CYAN = "\u001B[36m";

            if (!(playersStone.getLast() == null)) {
                for (Stone stone: playersStone){
                    int stonesChoice = ThreadLocalRandom.current().nextInt(1, 4);

                    System.out.println("\n🪨 You embed the mystical stone " + stone.getName() + " into the hero's heart, its power coursing through their veins...");
                    pauseStory(1);

                    switch (stonesChoice){
                        case 1:
                            System.out.println(RED + "❤️ The stone radiates with energy, enhancing their health" + RESET);
                            pauseStory(1);

                            if (stone.getAbility().equals(player.getPlayersHero().getSpecialAbility())){
                                System.out.println(YELLOW + "🌟 Special abilities matched! [" + stone.getAbility() + "] – Points doubled!\n" + RESET);
                                pauseStory(1);
                                player.getPlayersHero().setLife(player.getPlayersHero().getLife() + (stone.getUpgradePoints() * 2));
                            } else {
                                player.getPlayersHero().setLife(player.getPlayersHero().getLife() + stone.getUpgradePoints());
                            }
                            break;
                        case 2:
                            System.out.println("⚔️ The stone pulses with power, infusing the hero with unmatched strength");
                            pauseStory(1);

                            if (stone.getAbility().equals(player.getPlayersHero().getSpecialAbility())){
                                System.out.println(YELLOW + "🌟 Special abilities matched! [" + stone.getAbility() + "] – Points doubled!\n" + RESET);
                                pauseStory(1);
                                player.getPlayersHero().setDamage(player.getPlayersHero().getDamage() + (stone.getUpgradePoints() * 2));
                            } else {
                                player.getPlayersHero().setDamage(player.getPlayersHero().getDamage() + stone.getUpgradePoints());
                            }
                            break;
                        case 3:
                            System.out.println(CYAN + "🛡️ The stone glows like a beam, fortifying the hero's defenses" + RESET);
                            pauseStory(1);

                            if (stone.getAbility().equals(player.getPlayersHero().getSpecialAbility())){
                                System.out.println(YELLOW + "🌟 Special abilities matched! [" + stone.getAbility() + "] – Points doubled!\n" + RESET);
                                pauseStory(1);
                                player.getPlayersHero().setArmor(player.getPlayersHero().getArmor() + (stone.getUpgradePoints() * 2));
                            } else {
                                player.getPlayersHero().setArmor(player.getPlayersHero().getArmor() + stone.getUpgradePoints());
                            }

                            break;
                    }
                }

                System.out.println(YELLOW + "✨ Your hero has leveled up!\n" + RESET +
                        "\n[New Stats]\n" +
                        player.getPlayersHero().getStats() + "\n");

                playersStone.clear();
            }
        } catch (Exception e) {
            System.out.println("\n🧐 Looks like you're out of stones! Time to gather more before your next challenge!");
        }

    }

    public static void goblinFight(){
        System.out.println("\nFunction is still being developed!");
    }

    public static void pauseStory(int ms) throws InterruptedException {
        //ms = ms * 1000;
        ms = ms * 100;
        Thread.sleep(ms);
    }
}
