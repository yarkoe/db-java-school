package homework.lab3.hero;

import homework.lab3.hero.strategies.DecreaseRandomKickStrategy;

import java.util.Random;

public class Knight extends Hero {

    public Knight(String name) {
        super(name, "Knight", new DecreaseRandomKickStrategy());

        Random random = new Random();
        this.power = 2 + random.nextInt(11);
        this.hp = 2 + random.nextInt(11);
    }
}
