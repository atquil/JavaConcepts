package interviewCodingQuestions.recursive;

public class RecursiveFactorial {
    public static void main(String[] args) {
        int number = 3321; // StackOverflow with large numbers

        System.out.println("Factorial of "+number+" : "+getRecursiveFactorial(number));
    }

  private static Integer getRecursiveFactorial(int number){
        if(number >= 1){
            return number + getRecursiveFactorial(number -1);
        }

        return number;
  }


}
