package homework.lab3.hero;

import homework.lab3.hero.strategies.DecreaseRandomKickStrategy;
import homework.lab3.hero.strategies.KickStrategy;

import java.util.Random;

public class King extends Hero {
    private Random random;

    public King(String name) {
        super(name, "King", new DecreaseRandomKickStrategy());
    }

    @Override
    void initPower() {
        this.power = 5 + random.nextInt(11);
    }

    @Override
    void initHp() {
        this.hp = 5 + random.nextInt(11);
    }
}
