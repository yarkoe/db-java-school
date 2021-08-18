package homework.lab3;

import homework.lab3.hero.Hero;
import homework.lab3.hero.HeroFactory;
import homework.lab3.history.FightHistory;

public class MainHeroes {

    public static void main(String[] args) {
        HeroFactory heroFactory = new HeroFactory();
        Hero hero1 = heroFactory.createHero();
        Hero hero2 = heroFactory.createHero();

        GameManager gameManager = new GameManager();
        FightHistory fightHistory = gameManager.fight(hero1, hero2);

        FightHistoryPrinter fightHistoryPrinter = new FightHistoryPrinter();
        fightHistoryPrinter.printHistory(fightHistory);
    }
}
