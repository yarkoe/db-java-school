package homework.lab3.hero;

import homework.lab3.RandomUtils;
import homework.lab3.hero.strategies.DecreaseRandomKickStrategy;

import java.util.Random;

public class Knight extends Hero {

    public Knight(String name) {
        super(name, "Knight", new DecreaseRandomKickStrategy());

        this.power = RandomUtils.generateIntBetweenBorders(2, 12);
        this.hp = RandomUtils.generateIntBetweenBorders(2, 12);
    }
}
