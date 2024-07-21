package java8Features;

import java.util.function.Function;

public class FunctionalChaining {
    public static void main(String[] args) {

        //Function<Input,Output>
        Function<Integer,Integer> dobleIT = number -> number*2;

        System.out.println("Doubling the unber"+dobleIT.apply(3)); //6

        Function<Integer,Integer> cubeIt = number->number*number*number;
        System.out.println("Cubing the number"+ cubeIt.apply(23));//12167

        // Functional Chaining
        System.out.println("Double then cube of number"+dobleIT.andThen(cubeIt).apply(151));//27543608

        System.out.println("Double then cube of number"+dobleIT.compose(cubeIt).apply(151)); //6885902

        Function<String,Integer> intergerToString = str -> Integer.valueOf(str);
        System.out.println(intergerToString.apply("2"));



    }
}
