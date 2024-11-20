import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        String inputParsed = input.chars().mapToObj(c -> 
                Character.isUpperCase((char) c) ? 
                Character.toLowerCase((char) c) :
                Character.toUpperCase((char) c))
            .map(c -> String.valueOf(c))
            .collect(Collectors.joining());
        
       System.out.println(inputParsed);
        
    }
}