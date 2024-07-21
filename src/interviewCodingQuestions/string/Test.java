package interviewCodingQuestions.string;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author atquil
 */
public class Test {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Atul", "Ema", "Anand");

      names.sort(Comparator.comparing(String::length));
    }
}
