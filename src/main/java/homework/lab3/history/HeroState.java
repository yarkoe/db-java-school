package homework.lab3.history;

public class HeroState {
    private final int power;
    private final int hp;

    public HeroState(int power, int hp) {
        this.power = power;
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public int getHp() {
        return hp;
    }
}
