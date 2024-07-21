package java8Features;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LambdaExpression {
    public static void main(String[] args) {

        List<String> str = Arrays.asList("zbc","efg");
        Collections.sort(str, String::compareTo);
        System.out.println(str);
    }
}
