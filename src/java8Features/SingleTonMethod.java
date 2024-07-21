package java8Features;

public class SingleTonMethod {
    public static void main(String[] args) {

        Singleton singleton = new Singleton();
       //No access to getInstanceOfMethod() --

        System.out.println(singleton.getInstance());

    }
}

class Singleton {

    private static String something = "Here is the username and password";

    private String getInstanceOfMethod(){
        return something;
    }

    //We can only access it using it's own method
    public String getInstance(){
        return getInstanceOfMethod();
    }
}