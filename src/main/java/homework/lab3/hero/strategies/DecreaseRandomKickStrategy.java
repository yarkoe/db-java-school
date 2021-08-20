package homework.lab3.hero.strategies;

import homework.lab3.RandomUtils;
import homework.lab3.hero.Hero;

import java.util.Random;

public class DecreaseRandomKickStrategy implements KickStrategy {
    @Override
    public void kick(Hero hero, Hero enemy) {
        int kickPower = RandomUtils.generateIntBetweenBorders(1, hero.getPower());
        enemy.decreaseHp(kickPower);
    }
}
