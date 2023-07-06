package interviewCodingQuestions.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Anagram: Have same words, binary | brainy or adobe| abode
public class AnagramAndCountIt {
    public static void main(String[] args) {

        List<String> inputWords = List.of("binary", "brainy", "adobe");

        // Sort --> group

        Map<String, Long> anagramWithCount = inputWords.stream()
                .map(word->{
                    char[] wordChar = word.toCharArray();
                    Arrays.sort(wordChar);
                    return new String(wordChar);
                }).collect(Collectors.groupingBy(word->word,Collectors.counting()));

        anagramWithCount.forEach((key, value) -> System.out.println(key + " occured:" + value));
    }
}
