package homework.lab3.hero;

public interface Hero {
    int getPower();
    void decreasePower(int amount);
    int getHp();
    void decreaseHp(int amount);
    void die();
    String getName();
    String getType();

    void kick(Hero enemy);
}
