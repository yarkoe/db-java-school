package homework.lab3.history;

import homework.lab3.hero.Hero;

public class FightState {
    private final Hero attacker;
    private final Hero defender;
    private final int power;
    private final int hp;

    public FightState(Hero attacker, Hero defender, int power, int hp) {
        this.attacker = attacker;
        this.defender = defender;
        this.power = power;
        this.hp = hp;
    }

    public Hero getAttacker() {
        return attacker;
    }

    public Hero getDefender() {
        return defender;
    }

    public int getPower() {
        return power;
    }

    public int getHp() {
        return hp;
    }
}
