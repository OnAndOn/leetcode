package miniParser4;

import java.util.List;

/**
 * Created by chenyang on 16/10/26.
 */

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class Main {

    public NestedInteger deserialize(String s){

        if(s.isEmpty()) {
            return new NestedInteger();
        }

        char[] chars = s.toCharArray();
        if(chars[0] != '[') {
            NestedInteger nestedInteger = new NestedInteger();
            nestedInteger.setInteger(Integer.parseInt(s));
            return nestedInteger;
        }

        if(s.length() <= 2) {
            return new NestedInteger();
        }
        int start = 1;
        int sameLevel = 0;
        NestedInteger result = new NestedInteger();

        for(int i = 1; i < chars.length; i++) {

            if(sameLevel ==0 && (chars[i] == ',' || i == chars.length - 1)){
                result.add(deserialize(s.substring(start, i)));
                start = i + 1;
            } else if (chars[i] == '[') {
                sameLevel++;
            } else if (chars[i] == ']') {
                sameLevel--;
            }
        }

        return result;
    }
}
