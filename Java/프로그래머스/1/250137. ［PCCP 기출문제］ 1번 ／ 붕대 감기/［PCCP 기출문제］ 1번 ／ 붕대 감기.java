class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int previousAttackTime = 0;

        for (int[] attack : attacks) {
            int healingTime = attack[0] - previousAttackTime - 1;
            int attackDamage = attack[1];

            health = Math.min(maxHealth, health + getHealing(bandage, healingTime));
            health -= attackDamage;

            if (health <= 0) {
                return -1;
            }

            previousAttackTime = attack[0];
        }

        return health;
    }

    private int getHealing(int[] bandage, int healingTime) {
        int chargeTime = bandage[0];
        int healingPerSec = bandage[1];
        int healingAfterSuccess = bandage[2];

        return healingTime * healingPerSec + (healingTime / chargeTime) * healingAfterSuccess;
    }
}