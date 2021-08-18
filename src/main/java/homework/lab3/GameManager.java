package homework.lab3;

import homework.lab3.hero.Hero;
import homework.lab3.history.FightHistory;
import homework.lab3.history.FightResultStatus;

public class GameManager {
    public FightHistory fight(Hero hero1, Hero hero2) {
        FightHistory fightHistory = new FightHistory(hero1, hero2);

        while (hero1.isAlive() && hero2.isAlive()) {
            manageKick(hero1, hero2, fightHistory);
            manageKick(hero2, hero1, fightHistory);
        }

        if (!hero1.isAlive() && !hero2.isAlive()) {
            fightHistory.setResultStatus(FightResultStatus.NOBODY_WON);
        } else if (hero1.isAlive()) {
            fightHistory.setResultStatus(FightResultStatus.HERO1_WON);
        } else {
            fightHistory.setResultStatus(FightResultStatus.HERO2_WON);
        }

        return fightHistory;
    }

    private void manageKick(Hero attacker, Hero defender, FightHistory fightHistory) {
        int previousHeroPower = defender.getPower();
        int previousHeroHp = defender.getHp();
        attacker.kick(defender);
        fightHistory.saveHero1KickHero2(attacker, defender, previousHeroPower - defender.getPower(), previousHeroHp - defender.getHp());
    }
}
