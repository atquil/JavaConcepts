package interviewCodingQuestions.string;

public class Palindrome {
    public static void main(String[] args) {
        String checkPalindrome ="MadM";

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
