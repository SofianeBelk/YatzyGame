package yatzy.classes;

import yatzy.interfaces.IDice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Dice implements IDice {
    private final List<Integer> faces;

    public Dice(int d1, int d2, int d3, int d4, int d5) {
        this.faces = Arrays.asList(d1, d2, d3, d4, d5);
    }

    private Map<Integer, Long> counts() {
        return this.faces.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public int sum() {
        return this.faces.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public boolean hasElementWithNumberFive() {
        return counts().values().stream()
                .anyMatch(value -> value == 5);
    }

    @Override
    public int diceCount(int face) {
        return counts().getOrDefault(face, 0L).intValue();
    }

    @Override
    public List<Integer> findPairs() {
        return counts().entrySet().stream()
                .filter(x -> x.getValue() >= 2)
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    @Override
    public int getDiceWithNumberOfAKind(int n) {
        return counts().entrySet().stream()
                .filter(x -> x.getValue() >= n)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }

    @Override
    public boolean isSmallStraight() {
        return faces.stream().sorted().collect(Collectors.toList()).equals(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Override
    public boolean isLargeStraight() {
        return faces.stream().sorted().collect(Collectors.toList()).equals(Arrays.asList(2, 3, 4, 5, 6));
    }

}
