package flattennestedlistiIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chenyang on 16/10/30.
 */

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list = new ArrayList<Integer>();
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {

        for(NestedInteger nestedInteger : nestedList) {
            addNestedInteger(nestedInteger);
        }

        iterator = list.iterator();
    }

    private void addNestedInteger(NestedInteger nestedInteger) {
        if(nestedInteger.isInteger()) {
            list.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger nestedInteger1 : nestedInteger.getList()) {
                addNestedInteger(nestedInteger1);
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }



    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public void remove() {

    }
}
