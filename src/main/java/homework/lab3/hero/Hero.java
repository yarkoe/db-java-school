package homework.lab3.hero;

import homework.lab3.hero.strategies.KickStrategy;

public abstract class Hero {
    private final String name;
    private final String type;

    protected int power;
    protected int hp;

    private final KickStrategy kickStrategy;

    public Hero(String name, String type, KickStrategy kickStrategy) {
        this.name = name;
        this.type = type;
        this.kickStrategy = kickStrategy;
    }

    public int getPower() {
        return power;
    }

    public void decreasePower(int amount) {
        power -= amount;
    }

    public int getHp() {
        return hp;
    }

    public void decreaseHp(int amount) {
        hp -= amount;
    }

    public void die() {
        hp = 0;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void kick(Hero enemy) {
        kickStrategy.kick(this, enemy);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
