package exceptionHandling;

class UserDefinedException extends Exception{

    private String message;

    UserDefinedException(String message){
        this.message = message;
    }

}
public class ExceptionChainingExample {
    public static void main(String[] args) {

        try{
            if(2<4){
                UserDefinedException userDefinedException = new UserDefinedException("SOMETHING");
                userDefinedException.initCause(new ArithmeticException("Arthemetic Excaption")); //Internal Cause of excepiton
                throw userDefinedException;
            }
        }catch (Exception e){
            System.out.println("Inside Cathc block");
            System.out.println("Message: "+e.getMessage());
            System.out.println("Cause : "+e.getCause());
            throw new RuntimeException("Chained Exception : due to ",e.getCause());
        }
    }
}
