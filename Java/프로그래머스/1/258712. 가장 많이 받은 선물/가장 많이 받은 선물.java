import java.util.Arrays;
import java.util.List;

class Solution {
    
    public static int solution(String[] friends, String[] gifts) {
        int[][] giftTable = getGiftTable(friends, gifts);
        int[] giftPoints = getGiftPoints(giftTable, friends.length);

        int[] giftToReceive = getGiftToReceive(giftTable, giftPoints, friends.length);

        return Arrays.stream(giftToReceive).max().orElse(0);
    }

    private static int[][] getGiftTable(String[] friends, String[] gifts) {
        int[][] giftTable = new int[friends.length][friends.length];

        List<String> friendsParsed = List.of(friends);

        for (String gift : gifts) {
            String giver = gift.split(" ")[0];
            String taker = gift.split(" ")[1];

            giftTable[friendsParsed.indexOf(giver)][friendsParsed.indexOf(taker)] += 1;
        }

        return giftTable;
    }

    private static int[] getGiftPoints(int[][] giftTable, int friendsCount) {
        int[] giftPoints = new int[friendsCount];

        for (int giver = 0; giver < friendsCount; giver++) {
            for (int taker = 0; taker < friendsCount; taker++) {
                int giftCount = giftTable[giver][taker];

                giftPoints[giver] += giftCount;
                giftPoints[taker] -= giftCount;
            }
        }

        return giftPoints;
    }

    private static int[] getGiftToReceive(int[][] giftTable, int[] giftPoints, int friendsCount) {
        int[] giftToReceive = new int[friendsCount];

        for (int giver = 0; giver < friendsCount; giver++) {
            for (int taker = 0; taker < friendsCount; taker++) {
                Boolean giverGaveMore = didGiverGiveMore(giftTable, giver, taker);
                boolean giverHasMorePoint = doesGiverHaveMorePoint(giftPoints, giver, taker);

                if (giverGaveMore != null && giverGaveMore) {
                    giftToReceive[giver] += 1;
                }
                if (giverGaveMore == null && giverHasMorePoint) {
                    giftToReceive[giver] += 1;
                }
            }
        }

        return giftToReceive;
    }

    
    private static Boolean didGiverGiveMore(int[][] giftTable, int giver, int taker) {
        if (giftTable[giver][taker] == giftTable[taker][giver]) {
            return null;
        }

        return giftTable[giver][taker] > giftTable[taker][giver];
    }

    private static boolean doesGiverHaveMorePoint(int[] giftPoints, int giver, int taker) {
        return giftPoints[giver] > giftPoints[taker];
    }
}