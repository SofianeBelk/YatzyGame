package yatzy;

import yatzy.classes.Dice;

import java.util.List;

public class YatzyPartition {

    private YatzyPartition() {
        throw new UnsupportedOperationException("this constructor is not available");
    }

    public static int chance(Dice dice) {
        return dice.sum();
    }

    public static int yatzy(Dice dice) {
        if (dice.hasElementWithNumberFive())
            return 50;
        return 0;
    }

    public static int ones(Dice dice) {
        return dice.diceCount(1);
    }

    public static int twos(Dice dice) {
        return dice.diceCount(2) * 2;
    }

    public static int threes(Dice dice) {
        return dice.diceCount(3) * 3;
    }

    public static int fours(Dice dice) {
        return dice.diceCount(4) * 4;
    }

    public static int fives(Dice dice) {
        return dice.diceCount(5) * 5;
    }

    public static int sixes(Dice dice) {
        return dice.diceCount(6) * 6;
    }

    public static int pair(Dice dice) {
        List<Integer> pairs = dice.findPairs();

        if (pairs.isEmpty()) return 0;

        return pairs.get(0) * 2;

    }

    public static int twoPairs(Dice dice) {

        List<Integer> pairs = dice.findPairs();

        if (pairs.size() >= 2) return pairs.stream().mapToInt(x -> x * 2).sum();

        return 0;
    }

    public static int threeOfAKind(Dice dice) {
        return dice.getDiceWithNumberOfAKind(3) * 3;
    }

    public static int fourOfAKind(Dice dice) {
        return dice.getDiceWithNumberOfAKind(4) * 4;
    }


    public static int smallStraight(Dice dice) {
        if (dice.isSmallStraight())
            return 15;
        return 0;
    }

    public static int largeStraight(Dice dice) {
        if (dice.isLargeStraight())
            return 20;
        return 0;
    }

    public static int fullHouse(Dice dice) {
        if (!dice.hasElementWithNumberFive() && !dice.findPairs().isEmpty() && dice.getDiceWithNumberOfAKind(3) != 0)
            return dice.sum();
        return 0;
    }
}


