package homework.lab3.hero;

import homework.lab3.hero.strategies.DecreaseRandomKickStrategy;
import homework.lab3.hero.strategies.KickStrategy;

import java.util.Random;

public class King extends Hero {
    private final Random random = new Random();

    public King(String name) {
        super(name, "King", new DecreaseRandomKickStrategy());
        this.power = 5 + random.nextInt(11);
        this.hp = 5 + random.nextInt(11);
    }
}
