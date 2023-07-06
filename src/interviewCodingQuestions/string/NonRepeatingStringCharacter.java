package interviewCodingQuestions.string;

import java.util.*;
import java.util.stream.Collectors;

public class NonRepeatingStringCharacter {
    public static void main(String[] args) {
        String s = "SpringBoot";

        //Using Set
        char[] charWord = s.toCharArray();
        Set<Character> uniqueCHar = new HashSet<>(); //Not a threadSafe and require synchronization
        for(char c: charWord){
            uniqueCHar.add(c); //will not add if value already present
        }
        System.out.println(uniqueCHar);

        System.out.println("============================================");

        //Using Map
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> charCount = new HashMap<>();

        for(char c: chars){
            if (!charCount.containsKey(c)){
                charCount.put(c,1);
            }
        }

        charCount.forEach((key,value)->System.out.println(key+":"+value));


        System.out.println("============================================");
        List<Character> output = charCount.entrySet().stream()
                .filter(characterIntegerEntry -> characterIntegerEntry.getValue()==1)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(output);


    }
}
