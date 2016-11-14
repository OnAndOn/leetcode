public class SingleNumber {

    public int[] singleNumber(int[] nums) {

        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums) {

            if(map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, 0);
            }

        }

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index] = entry.getKey();
            index++;
        }


        return result;

    }

    public static void main(String[] args) {

        SingleNumber instance = new SingleNumber();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = instance.singleNumber(nums);

        System.out.println(result[0] + " " + result[1]);

       
    }
}