package homework.lab3.hero;

import homework.lab3.hero.strategies.KickStrategy;
import homework.lab3.hero.strategies.KillWeakerKickStrategy;

public class Elf extends Hero {
    public Elf(String name) {
        super(name, "Elf", new KillWeakerKickStrategy());
        this.power = 10;
        this.hp = 10;
    }
}
