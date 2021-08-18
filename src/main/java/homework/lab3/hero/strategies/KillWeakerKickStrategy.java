package homework.lab3.hero.strategies;

import homework.lab3.hero.Hero;

public class KillWeakerKickStrategy implements KickStrategy {
    private final Hero owner;

    public KillWeakerKickStrategy(Hero owner) {
        this.owner = owner;
    }

    @Override
    public void kick(Hero enemy) {
        if (enemy.getPower() < owner.getPower()) {
            enemy.die();
        } else {
            enemy.decreasePower(1);
        }
    }
}
