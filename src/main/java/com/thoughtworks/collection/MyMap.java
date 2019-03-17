package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(i -> 3 * i).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(this::getLetter).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map(i -> getLetter(i)).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }

    private String getLetter(int n){
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0){
            int rest = n % 26;
            n /= 26;
            if(rest == 0){
                stringBuilder .insert(0,'z');
                n -= 1;
            } else {
                stringBuilder.insert(0,letters[rest-1]);
            }
        }
        return stringBuilder.toString();
    }
}
