package reflectionApi;


import java.lang.reflect.Field;

class Match{
    private String teamName;

    public Match(String teamName){
        this.teamName= teamName;
    }
}
public class AccessPrivateField {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Match match = new Match("RR");

        //We are not able to access teamName;
        Field field = match.getClass().getDeclaredField("teamName");
        field.setAccessible(true);
        System.out.println(field.get(match));
    }
}
