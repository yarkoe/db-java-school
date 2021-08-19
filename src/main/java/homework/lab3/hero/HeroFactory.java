package homework.lab3.hero;

import com.github.javafaker.Faker;
import homework.lab3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class HeroFactory {
    private final List<Function<String, Hero>> heroCreators = new ArrayList<>();
    private final Faker faker = new Faker();

    public HeroFactory() {
        heroCreators.add(Hobbit::new);
        heroCreators.add(Elf::new);
        heroCreators.add(King::new);
        heroCreators.add(Knight::new);
    }

    public Hero createHero() {
        int heroRandomIndex = RandomUtils.generateIntBetweenBorders(0, heroCreators.size() - 1);

        return heroCreators.get(heroRandomIndex).apply(faker.gameOfThrones().character());
    }
}
