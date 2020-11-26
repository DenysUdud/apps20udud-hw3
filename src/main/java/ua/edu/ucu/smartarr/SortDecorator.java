package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator myComp;

    public SortDecorator(SmartArray smartArray, MyComparator myComparator) {
        super(smartArray);
        this.myComp = myComparator;
        sortByComparator();
    }

    @Override
    public String operationDescription() {
        return smartArray.toString() + " SortDecorator";
    }

    private void sortByComparator() {
        decoratedArray = smartArray.toArray();
        Arrays.sort(decoratedArray, myComp);

    }
}
