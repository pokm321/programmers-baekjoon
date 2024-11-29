import java.util.stream.Collectors;

class Solution {
    public String solution(String s, String skip, int index) {

        return s.chars()
                .map(c -> parse(c, skip, index))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    private int parse(int c, String skip, int index) {
        for (int i = 0; i < index; i++) {
            do {
                c = getAlphabet(c + 1);
            } while (skip.contains(String.valueOf((char) c)));
        }

        return c;
    }

    private int getAlphabet(int c) {
        int a = 'a';
        int z = 'z';
        return (c - a) % (z - a + 1) + a;
    }
}