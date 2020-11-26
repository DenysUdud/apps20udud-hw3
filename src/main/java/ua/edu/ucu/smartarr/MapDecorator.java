package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.stream.Stream;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private Object[] decoratedArray;
    private MyFunction myFunc;

    public MapDecorator(SmartArray smartArray, MyFunction myFunction) {
        super(smartArray);
        this.myFunc = myFunction;
        applyMap();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(decoratedArray, decoratedArray.length);
    }

    @Override
    public String operationDescription() {
        return smartArray.toString() + " MapDecorator";
    }

    @Override
    public int size() {
        return decoratedArray.length;
    }

    private void applyMap() {
        Stream<Object> arrayStream = Arrays.stream(smartArray.toArray());
        decoratedArray = arrayStream.map(myFunc::apply).toArray();
    }
}
