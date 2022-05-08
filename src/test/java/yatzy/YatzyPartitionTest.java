package yatzy;

import org.junit.Test;
import yatzy.classes.Dice;

import static org.junit.Assert.assertEquals;
import static yatzy.interfaces.Category.*;

public class YatzyPartitionTest {

    @Test
    public void chance() {
        assertEquals(15, Chance.getScore(new Dice(2, 3, 4, 5, 1)));
        assertEquals(16, Chance.getScore(new Dice(3, 3, 4, 5, 1)));
        assertEquals(14, Chance.getScore(new Dice(1, 1, 3, 3, 6)));
        assertEquals(21, Chance.getScore(new Dice(4, 5, 5, 6, 1)));
    }

    @Test
    public void yatzy() {
        assertEquals(50, Yatzy.getScore(new Dice(4, 4, 4, 4, 4)));
        assertEquals(50, Yatzy.getScore(new Dice(6, 6, 6, 6, 6)));
        assertEquals(0,  Yatzy.getScore(new Dice(6, 6, 6, 6, 3)));
        assertEquals(50, Yatzy.getScore(new Dice(1, 1, 1, 1, 1)));
        assertEquals(0,  Yatzy.getScore(new Dice(1, 1, 1, 2, 1)));
    }

    @Test
    public void ones() {
        assertEquals(1, Ones.getScore(new Dice(1, 2, 3, 4, 5)));
        assertEquals(2, Ones.getScore(new Dice(1, 2, 1, 4, 5)));
        assertEquals(0, Ones.getScore(new Dice(6, 2, 2, 4, 5)));
        assertEquals(4, Ones.getScore(new Dice(1, 2, 1, 1, 1)));
        assertEquals(0, Ones.getScore(new Dice(3, 3, 3, 4, 5)));
    }

    @Test
    public void twos() {
        assertEquals(4,  Twos.getScore(new Dice(1, 2, 3, 2, 6)));
        assertEquals(10, Twos.getScore(new Dice(2, 2, 2, 2, 2)));
        assertEquals(4,  Twos.getScore(new Dice(2, 3, 2, 5, 1)));
    }

    @Test
    public void threes() {
        assertEquals(6,  Threes.getScore(new Dice(1, 2, 3, 2, 3)));
        assertEquals(12, Threes.getScore(new Dice(2, 3, 3, 3, 3)));
    }

    @Test
    public void fours() {
        assertEquals(12, Fours.getScore(new Dice(4, 4, 4, 5, 5)));
        assertEquals(8,  Fours.getScore(new Dice(4, 4, 5, 5, 5)));
        assertEquals(4,  Fours.getScore(new Dice(4, 5, 5, 5, 5)));
        assertEquals(8,  Fours.getScore(new Dice(1, 1, 2, 4, 4)));
    }

    @Test
    public void fives() {
        assertEquals(10, Fives.getScore(new Dice(4, 4, 4, 5, 5)));
        assertEquals(15, Fives.getScore(new Dice(4, 4, 5, 5, 5)));
        assertEquals(20, Fives.getScore(new Dice(4, 5, 5, 5, 5)));
    }

    @Test
    public void sixes() {
        assertEquals(0,  Sixes.getScore(new Dice(4, 4, 4, 5, 5)));
        assertEquals(6,  Sixes.getScore(new Dice(4, 4, 6, 5, 5)));
        assertEquals(18, Sixes.getScore(new Dice(6, 5, 6, 6, 5)));
    }

    @Test
    public void pair() {
        assertEquals(6,  Pair.getScore(new Dice(3, 4, 3, 5, 6)));
        assertEquals(10, Pair.getScore(new Dice(5, 3, 3, 3, 5)));
        assertEquals(12, Pair.getScore(new Dice(5, 3, 6, 6, 5)));
        assertEquals(0,  Pair.getScore(new Dice(1, 2, 3, 4, 5)));
        assertEquals(8,  Pair.getScore(new Dice(3, 3, 3, 4, 4)));
        assertEquals(12, Pair.getScore(new Dice(1, 1, 6, 2, 6)));
        assertEquals(6,  Pair.getScore(new Dice(3, 3, 3, 4, 1)));
        assertEquals(6,  Pair.getScore(new Dice(3, 3, 3, 3, 1)));
    }

    @Test
    public void twoPairs() {
        assertEquals(16, TwoPairs.getScore(new Dice(3, 3, 5, 4, 5)));
        assertEquals(16, TwoPairs.getScore(new Dice(3, 3, 5, 5, 5)));
        assertEquals(8,  TwoPairs.getScore(new Dice(1, 1, 2, 3, 3)));
        assertEquals(0,  TwoPairs.getScore(new Dice(1, 1, 2, 3, 4)));
        assertEquals(6,  TwoPairs.getScore(new Dice(1, 1, 2, 2, 2)));
        assertEquals(0,  TwoPairs.getScore(new Dice(3, 3, 3, 3, 1)));
    }

    @Test
    public void threeOfAKind() {
        assertEquals(9,  ThreeOfAKind.getScore(new Dice(3, 3, 3, 4, 5)));
        assertEquals(15, ThreeOfAKind.getScore(new Dice(5, 3, 5, 4, 5)));
        assertEquals(9,  ThreeOfAKind.getScore(new Dice(3, 3, 3, 3, 5)));
        assertEquals(9,  ThreeOfAKind.getScore(new Dice(3, 3, 3, 3, 3)));
        assertEquals(9,  ThreeOfAKind.getScore(new Dice(3, 3, 3, 3, 1)));
        assertEquals(0,  ThreeOfAKind.getScore(new Dice(3, 3, 4, 5, 6)));
    }

    @Test
    public void fourOfAKind() {
        assertEquals(12, FourOfAKind.getScore(new Dice(3, 3, 3, 3, 5)));
        assertEquals(20, FourOfAKind.getScore(new Dice(5, 5, 5, 4, 5)));
        assertEquals(8,  FourOfAKind.getScore(new Dice(2, 2, 2, 2, 5)));
        assertEquals(0,  FourOfAKind.getScore(new Dice(2, 2, 2, 5, 5)));
        assertEquals(8,  FourOfAKind.getScore(new Dice(2, 2, 2, 2, 2)));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, SmallStraight.getScore(new Dice(1, 2, 3, 4, 5)));
        assertEquals(15, SmallStraight.getScore(new Dice(2, 3, 4, 5, 1)));
        assertEquals(0,  SmallStraight.getScore(new Dice(1, 2, 2, 4, 5)));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, LargeStraight.getScore(new Dice(6, 2, 3, 4, 5)));
        assertEquals(20, LargeStraight.getScore(new Dice(2, 3, 4, 5, 6)));
        assertEquals(0,  LargeStraight.getScore(new Dice(1, 2, 2, 4, 5)));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, FullHouse.getScore(new Dice(6, 2, 2, 2, 6)));
        assertEquals(0,  FullHouse.getScore(new Dice(2, 3, 4, 5, 6)));
        assertEquals(8,  FullHouse.getScore(new Dice(1, 1, 2, 2, 2)));
        assertEquals(0,  FullHouse.getScore(new Dice(2, 2, 3, 3, 4)));
        assertEquals(0,  FullHouse.getScore(new Dice(4, 4, 4, 4, 4)));
    }
}