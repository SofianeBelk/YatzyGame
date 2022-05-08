package yatzy.interfaces;

import java.util.List;

public interface IDice {

    int sum();

    boolean hasElementWithNumberFive();

    int diceCount(int face);

    List<Integer> findPairs();

    int getDiceWithNumberOfAKind(int n);

    boolean isSmallStraight();

    boolean isLargeStraight();

}
