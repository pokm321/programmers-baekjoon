import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s, String skip, int index) {
        List<Integer> skipParsed = skip.chars().boxed().collect(Collectors.toList());

        return s.chars()
                .map(c -> parse(c, skipParsed, index))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    private int parse(int c, List<Integer> skipParsed, int index) {
        for (int i = 0; i < index; i++) {
            do {
                c = getAlphabet(c + 1);
            } while (skipParsed.contains(c));
        }

        return c;
    }

    private int getAlphabet(int c) {
        int a = 'a';
        int z = 'z';
        return (c - a) % (z - a + 1) + a;
    }
}