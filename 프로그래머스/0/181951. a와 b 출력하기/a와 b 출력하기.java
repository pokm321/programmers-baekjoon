import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        System.out.println("a = " + line.split(" ")[0]);
        System.out.println("b = " + line.split(" ")[1]);
    }
}