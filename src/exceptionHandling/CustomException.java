package exceptionHandling;


import java.io.IOException;

class MyCustomException extends RuntimeException{
    public MyCustomException(String message) {
        System.out.println("Exception from :"+message);
    }
}
public class CustomException {
    public static void main(String[] args) {
        if(2<3){
            try{
                throw new MyCustomException("My Custom Excepiton");
            }catch (Exception e){
                System.out.println("Catching my own exception:"+e);
            }

        }
    }
}
