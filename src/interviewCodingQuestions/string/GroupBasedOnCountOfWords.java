package interviewCodingQuestions.string;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBasedOnCountOfWords {

    public static void main(String[] args) {
        List<String> inputWordList = List.of("hi", "i", "am","atul");

        Map<Integer,List<String>> mapWithCountAndWords = inputWordList.stream()
                .collect(Collectors.groupingBy(word->word.length(), Collectors.toList()));
        mapWithCountAndWords.forEach((key,value)->System.out.println(key+":"+value));
        System.out.println("============================================");

        Map<Integer,List<String>> mapWithCountAndWords1 = inputWordList.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toList()));

        mapWithCountAndWords1.entrySet().forEach(word->System.out.println(word.getKey()+":"+word.getValue()));

        System.out.println("============================================");
        Map<Integer,List<String>> mapWithCountAndWords2 = inputWordList.stream()
                .collect(Collectors.groupingBy(String::length));

        for(Map.Entry wordMap: mapWithCountAndWords2.entrySet()){
            System.out.println(wordMap.getKey()+":"+wordMap.getValue());
        }


    }


}
