package interviewCodingQuestions.string;

import java.util.Arrays;

public class Palindrome {
    public static void main(String[] args) {
        String checkPalindrome ="MDadM";
        StringBuilder stringBuilder = new StringBuilder(checkPalindrome.toLowerCase());
        stringBuilder.reverse();
        if(stringBuilder.toString().equalsIgnoreCase(checkPalindrome)){
            System.out.println("Palindrome");
        }



        //Using StringBuilder
        System.out.println(isPalindrome(checkPalindrome));

        System.out.println("============================================");
        //Using array
        System.out.println(isPalindromeUsingPointer(checkPalindrome));
    }

    private static boolean isPalindromeUsingPointer(String checkPalindrome) {
        char[] inputToArray = checkPalindrome.toCharArray();

        int i = 0 ; //Starting position
        int j = inputToArray.length - 1;//Last position
        while(i<j) // median position reached
        {
            if(inputToArray[i]!=inputToArray[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isPalindrome(String checkPalindrome) {
        return checkPalindrome.equals(new StringBuilder(checkPalindrome).reverse().toString());
    }
}
