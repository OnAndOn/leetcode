package gassstation;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalCas = 0;
        int nowCas = 0;
        int startIndex = 0;

        for(int i = 0; i < gas.length; i++) {

            int left = gas[i] - cost[i];

            totalCas += left;

            nowCas = nowCas + left;

            if(nowCas < 0) {
                startIndex = i + 1;
                nowCas = 0;
            }
        }

        if(totalCas < 0 ) {
            return -1;
        }

        return startIndex % gas.length;
    }
}
