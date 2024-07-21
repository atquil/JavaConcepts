package java8Features;

public class StaticInterface implements someStaticInterface {
    public static void main(String[] args) {

        System.out.println(someStaticInterface.someInterface());
    }
}

interface someStaticInterface{
    static String someInterface(){
        return "Atul";
    }
}