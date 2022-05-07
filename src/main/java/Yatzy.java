import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts.values().stream()
                .filter(x -> x == 5)
                .findFirst()
                .map(elm -> 50)
                .orElse(0);
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts.getOrDefault(1, 0L).intValue();
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts.getOrDefault(2, 0L).intValue() * 2;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts.getOrDefault(3, 0L).intValue() * 3;
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts.getOrDefault(4, 0L).intValue() * 4;
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts.getOrDefault(5, 0L).intValue() * 5;
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts.getOrDefault(6, 0L).intValue() * 6;
    }

    public static int pair(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> pairs = counts.entrySet().stream()
                .filter(x -> x.getValue() >= 2)
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (pairs.isEmpty())
            return 0;

        return pairs.get(0) * 2;

    }

    public static int twoPairs(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> pairs = counts.entrySet().stream()
                .filter(x -> x.getValue() >= 2)
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (pairs.size() >= 2)
            return pairs.stream()
                    .mapToInt(x -> x * 2)
                    .sum();

        return 0;
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return counts.entrySet().stream()
                .filter(x -> x.getValue() >= 3)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0) * 3;
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return counts.entrySet().stream()
                .filter(x -> x.getValue() >= 4)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0) * 4;
    }


    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> maListe = Arrays.asList(d1, d2, d3, d4, d5).stream().sorted().collect(Collectors.toList());
        if (maListe.equals(Arrays.asList(1, 2, 3, 4, 5)))
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> maListe = Arrays.asList(d1, d2, d3, d4, d5).stream().sorted().collect(Collectors.toList());
        if (maListe.equals(Arrays.asList(2, 3, 4, 5, 6)))
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = Stream.of(d1, d2, d3, d4, d5)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        boolean hasPair = ! (counts.entrySet().stream()
                .filter(x -> x.getValue() >= 2)
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .isEmpty());

        boolean hasThreeOfAKind = counts.entrySet().stream()
                .filter(x -> x.getValue() >= 3)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0) != 0;

        boolean isYatzy = !counts.values().stream()
                .anyMatch(x -> x == 5);

        if(hasThreeOfAKind && hasPair && isYatzy)
            return d1+d2+d3+d4+d5;

        return 0;

    }
}


