package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    List<T> masterList = new ArrayList<T>();
    T[] array;

    public ArrayUtility(T[] inputArray) {
        for (T a: inputArray) {
            masterList.add(a);
        }
        array = Arrays.copyOf(inputArray, inputArray.length);
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {

        Integer count = 0;

        mergeArray(arrayToMerge);
        
        for (T a: masterList) {
            if(a.equals(valueToEvaluate))
            count++;
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        mergeArray(arrayToMerge);                               //Merge Array
        List<T> countedObjects = new ArrayList<>();
        TreeMap<T, Integer> countingObjects = new TreeMap<>();   //Use this to
        TreeMap<Integer, T> smallestToLargest = new TreeMap<>();
        Integer amount;

        for (int i = 0; i < masterList.size(); i++){
            if(!countedObjects.contains(masterList.get(i))){
                countedObjects.add(masterList.get(i));
                countingObjects.put(masterList.get(i), 1);
            }
            if(countedObjects.contains(masterList.get(i))){
                amount = countingObjects.get(masterList.get(i));
                amount++;
                countingObjects.put(masterList.get(i), amount);
            }
        }

        for (int i = 0; i<countedObjects.size(); i++){
            smallestToLargest.put(countingObjects.get(countedObjects.get(i)), countedObjects.get(i));
        }
        return smallestToLargest.get(smallestToLargest.lastKey());

    }

    public void mergeArray(T[] arrayToMerge){
        for (T a: arrayToMerge) {
            masterList.add(a);
        }
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (T a: masterList) {
            if(a.equals(valueToEvaluate)){
                count++;
            }
        }

        return count;
    }

    public T[] removeValue(T valueToRemove) {
        int occurences = getNumberOfOccurrences(valueToRemove);
        List<T> output = new ArrayList<>();
        for (T a: masterList) {
            if(!a.equals(valueToRemove)){
                output.add(a);
            }
        }
        masterList.remove(valueToRemove);

        T[] outputArray = Arrays.copyOf(array, array.length-occurences);
        return output.toArray(outputArray);
    }
}
