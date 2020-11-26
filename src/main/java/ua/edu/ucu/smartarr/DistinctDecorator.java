package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    /*
    Decorator is used to remove duplicates from SmartArray.
    Use method equals() to compare objects
     */
    private Object[] decoratedArray;
    private ArrayList<Object> distinctArrayList;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        distinctArrayList = new ArrayList<Object>();
        removeDuplicates();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(decoratedArray, decoratedArray.length);
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + " DistinctDecorator";
    }

    @Override
    public int size() {
        return decoratedArray.length;
    }

    private void removeDuplicates() {
        Stream<Object> arrayStream = Arrays.stream(smartArray.toArray());
        decoratedArray = arrayStream.filter(this::contains).toArray();
        distinctArrayList.clear();
    }

    private boolean contains(Object obj) {
        if (distinctArrayList.contains(obj)) {
            return false;
        }
        else {
            distinctArrayList.add(obj);
            return true;
        }
    }
}
