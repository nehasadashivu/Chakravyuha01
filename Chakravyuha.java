public class Chakravyuha {

    public static boolean canAbhimanyuReach(int p, int[] enemyPowers, int a, int b) {
        int skipCount = a;
        int rechargeCount = b;
        int initialPower = p;

        for (int i = 0; i < 11; i++) {
            if (p >= enemyPowers[i]) {
               
                p -= enemyPowers[i];
            } else if (skipCount > 0) {
               
                skipCount--;
            } else if (rechargeCount > 0) {
                
                rechargeCount--;
                p = initialPower;
                if (p >= enemyPowers[i]) {
                    p -= enemyPowers[i];
                } else {
                    return false;
                }
            } else {
                return false;
            }

           

            if (i == 3 || i == 7) 
{
                int backAttackIndex = i - 3;
                if (p < enemyPowers[backAttackIndex] / 2) {
                    return false;
                }
                p -= enemyPowers[backAttackIndex] / 2;
            }
        }

        return true;
    }

    public static void main(String[] args) {
      
        int initialPower1 = 10;
        int[] enemyPowers1 = {1, 2, 4, 6, 8, 3, 5, 9, 7, 2, 1};
        int a1 = 2; 
        int b1 = 1;
        boolean result1 = canAbhimanyuReach(initialPower1, enemyPowers1, a1, b1);
        System.out.println(result1 ? "Abhimanyu can reach the Pandavas army" : "Abhimanyu cannot reach the Pandavas army");

       
        int initialPower2 = 5;
        int[] enemyPowers2 = {2, 2, 4, 4, 3, 3, 2, 5, 6, 4, 3};
        int a2 = 3;
        int b2 = 2; 
        boolean result2 = canAbhimanyuReach(initialPower2, enemyPowers2, a2, b2);
        System.out.println(result2 ? "Abhimanyu can reach the Pandavas army" : "Abhimanyu cannot reach the Pandavas army");
    }
}