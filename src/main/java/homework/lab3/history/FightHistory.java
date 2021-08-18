package homework.lab3.history;

import homework.lab3.hero.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static homework.lab3.history.FightResultStatus.*;

public class FightHistory {
    private final List<FightState> fightStates = new ArrayList<>();
    private FightResultStatus resultStatus = NOBODY_WON;

    private final Hero hero1;
    private final Hero hero2;

    public FightHistory(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public void saveHero1KickHero2(Hero hero1, Hero hero2, int power, int hp) {
        fightStates.add(new FightState(hero1, hero2, power, hp));
    }

    public List<FightState> getFightStates() {
        return Collections.unmodifiableList(fightStates);
    }

    public void setResultStatus(FightResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public FightResultStatus getResultStatus() {
        return resultStatus;
    }

    public Hero getHero1() {
        return hero1;
    }

    public Hero getHero2() {
        return hero2;
    }
}
