package java8Features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReferenceing {
    public static void main(String[] args) {
        List<String> someList = Arrays.asList("Here ", "I ", "Am ", "There");

        Collections.sort(someList,String::compareTo);
        System.out.println("here"+someList);
        someList.sort(String::compareTo);
        someList.stream().forEach(System.out::println);
    }
}
