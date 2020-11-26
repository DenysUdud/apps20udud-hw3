package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;
import java.util.stream.Stream;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;
    private Object[] decoratedArray;

    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        super(smartArray);
        this.predicate = myPredicate;
        filterByPredicate();
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

    private void filterByPredicate() {
        Stream<Object> arrayStream = Arrays.stream(smartArray.toArray());
        decoratedArray = arrayStream.filter(predicate::test).toArray();
    }
}
