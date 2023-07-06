package interviewCodingQuestions.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombineListOfStringIntoSingleString {
    public static void main(String[] args) {
        List<String> givenStringList = Arrays.asList("I", " am", " atul");

        getJoinUsingStringBuilder(givenStringList);

        System.out.println("============================================");

        getJoinUsingStream(givenStringList);

    }

    private static void getJoinUsingStream(List<String> listOfString) {
        System.out.println(listOfString.stream().collect(Collectors.joining()));
    }

    private static void getJoinUsingStringBuilder(List<String> listOfString) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String word: listOfString){
            stringBuilder.append(word);
        }
        System.out.println(stringBuilder.toString());
    }

}
