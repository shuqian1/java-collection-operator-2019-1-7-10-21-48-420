package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        IntStream intStream = leftBorder < rightBorder ? IntStream.range(leftBorder,rightBorder+1) : IntStream.range(rightBorder,leftBorder+1);
        return intStream.filter(i -> i % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        IntStream intStream = leftBorder < rightBorder ? IntStream.range(leftBorder,rightBorder+1) : IntStream.range(rightBorder,leftBorder+1);
        return intStream.filter(i -> i % 2 != 0).sum();
    }


    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().collect(Collectors.summingInt(value -> 3 * value + 2));
    }


    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(i -> i % 2 == 0 ? i : 3 * i +2).collect(Collectors.toList());

    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(Integer::intValue).filter(i -> i % 2 != 0).map(i -> 3 * i + 5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> even = arrayList.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());
        return (even.get(even.size() / 2 - 1) + even.get(even.size() / 2) ) / 2;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.averagingDouble(i -> i));
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(i -> i % 2 == 0).anyMatch(i -> i.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> event = arrayList.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> odd = arrayList.stream().filter(i -> i % 2 != 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        event.addAll(odd);
        return event;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return IntStream.range(1,arrayList.size()).mapToObj(i -> (arrayList.get(i) + arrayList.get(i-1)) * 3).collect(Collectors.toList());
    }
}
