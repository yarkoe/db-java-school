package homework.lab3.hero.strategies;

import homework.lab3.hero.Hero;

import java.util.Random;

public class DecreaseRandomKickStrategy implements KickStrategy {
    private final Hero owner;
    private final Random random = new Random();


    public DecreaseRandomKickStrategy(Hero owner) {
        this.owner = owner;
    }

    @Override
    public void kick(Hero enemy) {
        int kickPower = random.nextInt(owner.getPower());
        enemy.decreaseHp(kickPower);
    }
}
