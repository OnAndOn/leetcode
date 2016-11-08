public class Solution {
    public int climbStairs(int n) {

        if(n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        int count = 2;

        while (count <= n) {
            dp[count] = dp[count - 1] + dp[count - 2];
            count++;
        }

        return dp[n];
    }

    public static void main(String[] args) {

        Solution instance = new Solution();
        System.out.println(instance.climbStairs(1));

    }
}