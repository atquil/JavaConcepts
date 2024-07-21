package interviewCodingQuestions.string;

import java.util.*;
import java.util.stream.Collectors;

//Anagram: Have same words, binary | brainy or adobe| abode
public class AnagramAndCountIt {
    public static void main(String[] args) {

        List<String> inputWords = List.of("binary", "brainy", "adobe");

        //Sort and store as key and value as anagram
       Map<String,Integer> anagramWords = new HashMap<>();

        inputWords.forEach(inputWord->{
            char[] wordChar = inputWord.toCharArray();
            Arrays.sort(wordChar);
            String sortedWord = new String(wordChar);

            if(anagramWords.containsKey(sortedWord)){
                anagramWords.put(sortedWord,anagramWords.get(sortedWord)+1);
            }else {
                //new word
                anagramWords.put(sortedWord,1);

            }
        });

       // Now print the Map
        anagramWords.forEach((key,value)->System.out.println(key+":"+value));
        System.out.println("--------------------");
        inputWords.stream().collect(Collectors.groupingBy(word->word,Collectors.counting()));

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
