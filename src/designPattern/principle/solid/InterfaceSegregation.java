package designPattern.principle.solid;


interface salaryComponent{

    //Common for emp
    void basePay();
    void hra();

    //But not all the emp will have these
    void flightAllowance();
    void hotelAllowance();
}

//Now suppose if implement it i will have to use all method
public class InterfaceSegregation implements salaryComponent{
    public static void main(String[] args) {
        InterfaceSegregation emp1 = new InterfaceSegregation();
        emp1.basePay();
        emp1.flightAllowance(); // but i don't have flight allowance
    }

    @Override
    public void basePay() {

    }

    @Override
    public void hra() {

    }

    @Override
    public void flightAllowance() {

    }

    @Override
    public void hotelAllowance() {

    }
}
