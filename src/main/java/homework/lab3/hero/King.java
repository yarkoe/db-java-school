package homework.lab3.hero;

import homework.lab3.RandomUtils;
import homework.lab3.hero.strategies.DecreaseRandomKickStrategy;

import java.util.Random;

public class King extends Hero {

    public King(String name) {
        super(name, "King", new DecreaseRandomKickStrategy());
        this.power = RandomUtils.generateIntBetweenBorders(5, 15);
        this.hp = RandomUtils.generateIntBetweenBorders(5, 15);
    }
}
