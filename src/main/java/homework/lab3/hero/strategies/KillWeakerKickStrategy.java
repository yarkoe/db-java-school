package homework.lab3.hero.strategies;

import homework.lab3.hero.Hero;

public class KillWeakerKickStrategy implements KickStrategy {
    @Override
    public void kick(Hero hero, Hero enemy) {
        if (enemy.getPower() < hero.getPower()) {
            enemy.die();
        } else {
            enemy.decreasePower(1);
        }
    }
}
