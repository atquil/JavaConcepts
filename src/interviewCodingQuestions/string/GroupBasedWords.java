package interviewCodingQuestions.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupBasedWords {
    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("here","something","here","check");

        //Using CollectionFramework:
        System.out.println(stringList.stream().collect(Collectors.groupingBy(word->word,Collectors.counting())));

        System.out.println("============================================");

        //Using Map:
        HashMap<String,Integer> uniqueWord = new HashMap<>();


        for(String s: stringList){
            if(uniqueWord.containsKey(s)){
                uniqueWord.put(s,uniqueWord.get(s) +1 );
            }else{
                uniqueWord.put(s,1);
            }
        }
        uniqueWord.forEach((key,value)->System.out.println(key+":"+value));
    }
}
