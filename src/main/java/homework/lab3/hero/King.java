package homework.lab3.hero;

import homework.lab3.hero.strategies.DecreaseRandomKickStrategy;

import java.util.Random;

public class King extends Hero {

    public King(String name) {
        super(name, "King", new DecreaseRandomKickStrategy());
        Random random = new Random();
        this.power = 5 + random.nextInt(11);
        this.hp = 5 + random.nextInt(11);
    }
}
