package homework.lab3.hero;

import homework.lab3.hero.strategies.DecreaseRandomKickStrategy;
import homework.lab3.hero.strategies.KickStrategy;

import java.util.Random;

public class Knight extends Hero {
    private final Random random = new Random();

    public Knight(String name) {
        super(name, "Knight", new DecreaseRandomKickStrategy());

        this.power = 2 + random.nextInt(11);
        this.hp = 2 + random.nextInt(11);
    }
}
