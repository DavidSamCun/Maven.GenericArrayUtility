package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    List<T> newList = new ArrayList<T>();

    public ArrayUtility(T[] inputArray) {
        for (T a: inputArray) {
            newList.add(a);
        }
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {

        Integer count = 0;

        for (T a: arrayToMerge) {
            newList.add(a);
        }
        
        for (T a: newList) {
            if(a.equals(valueToEvaluate))
            count++;
        }
        return count;
    }
}
