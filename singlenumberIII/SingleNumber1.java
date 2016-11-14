public class SingleNumber {

    public int[] singleNumber(int[] nums) {

        int[] result = new int[2];

        int last = 0;

        for (int i : nums) {

            last ^= i;
        }

        int any = last & (~(last - 1));


        result[0] = 0;
        result[1] = 0;
        for (int i : nums) {

            if((any & i) != 0) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 2, 5};
        SingleNumber instance = new SingleNumber();

        int[] result = instance.singleNumber(nums);

        System.out.println(result[0] + " " + result[1]);
    }
}
