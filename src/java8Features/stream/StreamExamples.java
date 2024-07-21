package java8Features.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1,3,2,2);
        int total1 = num.stream().sorted().mapToInt(Integer::intValue).sum();

        int total = num.stream().mapToInt(Integer::intValue).sum();

        int add = num.stream().mapToInt(Integer::intValue).sum();
       num.stream().sorted((n1,n2)->n1.compareTo(n2)).forEach(x->System.out.println(x));
       Optional<Integer> max = num.stream().max(Integer::compareTo);
    //   Optional<Integer> addition = num.Java8Features.stream().mapToDouble();
       if(max.isPresent()) System.out.println("--"+max.get());
    }
}
