package People;

import People.Person;

public class Student extends Person {


    public Student (String name, long UUID){
        super(name, UUID);
        this.setRetTime(10);

    }
}
