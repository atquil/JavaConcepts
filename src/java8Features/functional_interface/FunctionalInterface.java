package java8Features.functional_interface;

public class FunctionalInterface {
    public static void main(String[] args) {

    }
}
class ImplementFunctionalInterface implements MyFunctionalInterface {


    @Override
    public void doSomething() {
        System.out.println("I am here");
    }
}

