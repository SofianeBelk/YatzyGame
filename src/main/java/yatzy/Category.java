package yatzy;

import java.util.function.Function;

public enum Category {
    Chance(YatzyPartition::chance),
    Yatzy(YatzyPartition::yatzy),
    Ones(YatzyPartition::ones),
    Twos(YatzyPartition::twos),
    Threes(YatzyPartition::threes),
    Fours(YatzyPartition::fours),
    Fives(YatzyPartition::fives),
    Sixes(YatzyPartition::sixes),
    Pair(YatzyPartition::pair),
    TwoPairs(YatzyPartition::twoPairs),
    ThreeOfAKind(YatzyPartition::threeOfAKind),
    FourOfAKind(YatzyPartition::fourOfAKind),
    SmallStraight(YatzyPartition::smallStraight),
    LargeStraight(YatzyPartition::largeStraight),
    FullHouse(YatzyPartition::fullHouse);

    private final Function<Dice, Integer> result;

    Category(Function<Dice, Integer> result) {
        this.result = result;
    }

    public int getScore(Dice dice) {
        return this.result.apply(dice);
    }
}
