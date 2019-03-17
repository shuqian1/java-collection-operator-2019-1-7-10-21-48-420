package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        return left <= right ? IntStream.range(left,right+1).boxed().collect(Collectors.toList()) : IntStream.range(right,left+1).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> list = left <= right ? IntStream.range(left,right+1).boxed().collect(Collectors.toList()) : IntStream.range(right,left+1).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray).filter(i -> Arrays.stream(secondArray).anyMatch(j -> i == j)).boxed().collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(firstArray));
        list.addAll(Arrays.asList(secondArray));
        return list.stream().distinct().collect(Collectors.toList());
    }

}
