package ua.edu.ucu.smartarr;

import java.util.Arrays;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;
    protected Object[] decoratedArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(decoratedArray, decoratedArray.length);
    }

    @Override
    public int size() {
        return decoratedArray.length;
    }
}
