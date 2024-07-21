package reflectionApi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SomePrivateMethodClass{
    private String getName(){
        return "ReflectionApi";
    }

    private Integer getSquare(int i){
        return i * i;
    }

    private Integer getAdditon(int i, int j){
        return i + j;
    }
}
public class AccessPrivateMethod {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SomePrivateMethodClass somePrivateMethodClass = new SomePrivateMethodClass();
        //As it's a private method you will not be able to access it.
        //somePrivateMethodClass.getName()

        //Method() --> From ReflectionUtil
        Method method = SomePrivateMethodClass.class.getDeclaredMethod("getName");
        method.setAccessible(true);

        System.out.println("Access Private Method using:"+method.invoke(new SomePrivateMethodClass()));

        System.out.println("===================");

        Method methodWithParameter = SomePrivateMethodClass.class.getDeclaredMethod("getSquare", int.class);
        methodWithParameter.setAccessible(true);

        System.out.println("Square of 2 is:"+methodWithParameter.invoke(new SomePrivateMethodClass(),2));

        Method addValues = SomePrivateMethodClass.class.getDeclaredMethod("getAdditon", int.class, int.class);
        addValues.setAccessible(true);
        System.out.println("Additon of 1+ 2="+addValues.invoke(new SomePrivateMethodClass(),1,2));
    }
}

