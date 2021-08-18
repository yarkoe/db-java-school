package homework.lab3.history;

import homework.lab3.hero.Hero;

public class FightHistory {
    private HeroFightHistory hero1History;
    private HeroFightHistory hero2History;

    public FightHistory(Hero hero1, Hero hero2) {
        hero1History = new HeroFightHistory(hero1);
        hero2History = new HeroFightHistory(hero2);
    }

    public void addSnapshot(Hero hero1, Hero hero2) {
        hero1History.addHeroSnapshot(hero1);
        hero2History.addHeroSnapshot(hero2);
    }
}
