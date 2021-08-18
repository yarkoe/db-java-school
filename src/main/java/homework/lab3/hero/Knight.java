package homework.lab3.hero;

import homework.lab3.hero.strategies.DecreaseRandomKickStrategy;
import homework.lab3.hero.strategies.KickStrategy;

import java.util.Random;

public class Knight extends Hero {
    private Random random;

    public Knight(String name) {
        super(name, "Knight", new DecreaseRandomKickStrategy());
    }

    @Override
    void initPower() {
        this.power = 2 + random.nextInt(11);
    }

    @Override
    void initHp() {
        this.hp = 2 + random.nextInt(11);
    }
}
