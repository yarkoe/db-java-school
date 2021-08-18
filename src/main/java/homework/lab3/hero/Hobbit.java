package homework.lab3.hero;

import homework.lab3.hero.strategies.CryKickStrategy;
import homework.lab3.hero.strategies.KickStrategy;

public class Hobbit extends Hero{
    public Hobbit(String name) {
        super(name, "Hobbit", new CryKickStrategy());
    }

    void initPower() {
        this.power = 0;
    }

    @Override
    void initHp() {
        this.hp = 3;
    }
}
