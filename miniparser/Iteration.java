package miniParser3;

import java.util.List;
import java.util.Stack;

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
    public NestedInteger deserialize(String s) {

        if(s.isEmpty()) {
            return new NestedInteger();
        }

        char[] chars = s.toCharArray();
        if(chars[0] != '[') {
            NestedInteger nestedInteger = new NestedInteger();
            nestedInteger.setInteger(Integer.parseInt(s));
            return nestedInteger;
        }

        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        int start = 1;

        for(int i = 0; i < s.length(); i++) {

            if(chars[i] == '[') {
                stack.push(new NestedInteger());
                start = i + 1;
            }

            if(chars[i] == ',' || chars[i] == ']') {

                if(i > start) {        //*
                    stack.peek().add(new NestedInteger().setInteger(Integer.parseInt(s.substring(start, i))));
                }
                start = i + 1;

                if(chars[i] == ']') {
                    if(stack.size() > 1) {        //*
                        NestedInteger temp = stack.pop();
                        stack.peek().add(temp);
                    }
                }
            }

        }

        return stack.pop();

    }
}
