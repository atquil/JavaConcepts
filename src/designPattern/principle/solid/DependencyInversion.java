package designPattern.principle.solid;

public class DependencyInversion {
    CommerceStudent commerceStudent = new CommerceStudent();
    ScienceStudent scienceStudent = new ScienceStudent();

    College commerceCollege = new College(commerceStudent);
    College scienceCollege = new College(scienceStudent);
}

class College{


    //Solution : Here, we're using the dependency injection pattern to facilitate adding
    //           the StudentType dependency into the College class.
    private final StudentType studentType;
    College(StudentType studentType){
        this.studentType = studentType;
    }
}
interface StudentType {}
//Now our classes are decoupled and communicate through the Student Type abstraction
// We can easily switch type of Student now
class CommerceStudent implements StudentType{ }
class ScienceStudent implements StudentType{ }
