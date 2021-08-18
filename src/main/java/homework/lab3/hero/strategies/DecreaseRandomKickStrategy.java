package homework.lab3.hero.strategies;

import homework.lab3.hero.Hero;

import java.util.Random;

public class DecreaseRandomKickStrategy implements KickStrategy {
    private final Random random = new Random();

    @Override
    public void kick(Hero hero, Hero enemy) {
        int kickPower = random.nextInt(hero.getPower());
        enemy.decreaseHp(kickPower);
    }
}
