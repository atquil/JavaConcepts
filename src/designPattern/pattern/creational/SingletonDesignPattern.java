package designPattern.pattern.creational;

public class SingletonDesignPattern {
    public static void main(String[] args) {
       SingleTonInstance someInstance =  SingleTonInstance.getInstanceOfSingleton();
       someInstance.doSomething();
    }
}

class SingleTonInstance{

    //Create a static instance of a class
    private static final SingleTonInstance singleTonInstance = new SingleTonInstance();

    public static SingleTonInstance getInstanceOfSingleton(){
        return singleTonInstance;
    }

    public void doSomething(){
        System.out.println("Only singleInstance of the class will be used");
    }
}