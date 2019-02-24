package main;

import java.util.*;

public class Ques6 {
    /*Print the elements of an array in the decreasing frequency if 2 numbers have
   same frequency then print the one which came first.*/
    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 6, 1, 9, 5, 8, 8, 8};
        //We'll use element, count and index in this question

        List<Integer> integerList = new ArrayList<>();
        //creating list to find the frequency of elements
        for (int i : arr) integerList.add(i);

        //creating list of objects of array elements along with
        //their frequency(count) and index of occurrence
        List<ArrElement> elements = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            elements.add(new ArrElement(arr[i], Collections.frequency(integerList, arr[i]), i));
        }

        //sorting list in the increasing order so that we can obtain index of first occurrence of element
        Collections.sort(elements, new ValComparator());

        for (int i = 1; i < elements.size(); i++) {
            if (elements.get(i).getVal() == elements.get(i - 1).getVal())
                //i.e. if the current and the previous element of the list were same then,
                //set the index of first occurrence for element
                elements.get(i).setIndex(elements.get(i - 1).getIndex());
        }

        //sorting list in the decreasing order of frequency
        Collections.sort(elements, new CouComparator());

        System.out.println(
                "Printing the elements of array " + Arrays.toString(arr) + " in the decreasing frequency.\n" +
                        "Printing those which occurred first, in case two different elements have same frequency");

        //iterating through all the list element to print them in sorted order
        Iterator<ArrElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            ArrElement nextEl = iterator.next();
            System.out.println("Element: " + nextEl.getVal() + " Frequency: " + nextEl.getCount() + " Occurrence-Index:" +
                    " " + nextEl.getIndex());
        }
    }
}

class ArrElement {
    int count, index, val;

    public ArrElement(int val, int count, int index) {
        this.count = count;
        this.index = index;
        this.val = val;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

class ValComparator implements Comparator<ArrElement> {

    @Override
    public int compare(ArrElement o1, ArrElement o2) {
        return o1.getVal() - o2.getVal();
        //sorting elements in the increasing order of value contained by them
    }
}

class CouComparator implements Comparator<ArrElement> {

    @Override
    public int compare(ArrElement o1, ArrElement o2) {
        //if two element have same frequency, sort on basis of index
        if (o1.getCount() != o2.getCount())
            return (o2.getCount() - o1.getCount());
        else
            return o1.getIndex() - o2.getIndex();
    }
}
