package java8Features;

public class InterfaceLogic implements first,second{
    public static void main(String[] args) {

    }

    @Override
    public void someMethod() {
        first.super.someMethod();
    }
}

interface first{
    default void someMethod(){
        System.out.println("Here");
    }
}
interface second{
    default void someMethod(){
        System.out.println("there");
    }
}