package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public double getMinimum() {
        return arrayList.stream().mapToInt(Integer::intValue).min().orElse(0);
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(Integer::intValue).average().orElse(0);
    }


    public double getOrderedMedian() {
        List<Integer> list = arrayList.stream().sorted().collect(Collectors.toList());
        if(list.size() % 2 == 0){


            return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2 )) / 2.0;
        } else {
            return list.get(list.size() / 2);
        }
    }

    public int getFirstEven() {
        List<Integer> list = arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        return list.get(0);
    }

    public int getIndexOfFirstEven() {
        for (int i =0;i < arrayList.size();i++){
            if(arrayList.get(i) % 2 == 0){
                return i;
            }
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        return Arrays.equals(arrayList.toArray(),this.arrayList.toArray());
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        return (((Integer) singleLink.getNode((int) Math.floor((arrayList.size() + 1) / 2))).doubleValue() + ((Integer) singleLink.getNode((int) Math.ceil((arrayList.size() + 1) / 2.0))).doubleValue()) / 2.0;
    }

    public int getLastOdd() {
        List<Integer> list = arrayList.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        return list.get(list.size()-1);
    }

    public int getIndexOfLastOdd() {
       if(arrayList.stream().anyMatch(i -> i % 2 != 0)){
           return IntStream.range(0,arrayList.size()).reduce((accumulator,index) -> arrayList.get(index) % 2 != 0 ? index : accumulator).orElse(0);
       }
       return -1;
    }
}
