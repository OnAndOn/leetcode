public class Solution {

    public int numDecodings(String s) {

        if(s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        if(isValid(s.substring(0,1))) {
            dp[1] = 1;
        } else {
            dp[1] = 0;
        }


        for(int i = 2; i <= s.length(); i++) {

            if(isValid(s.substring(i-1, i))) {
                dp[i] += dp[i -1];
            }

            if(isValid(s.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    public boolean isValid(String s) {

        if(s.charAt(0) == '0') {
            return false;
        }

        if(s.length() > 1) {
            if(Integer.parseInt(s) > 26) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();

        String s = "1211";

        System.out.println(instance.numDecodings(s));

    }

}