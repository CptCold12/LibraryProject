package People;

import People.Person;

public class Faculty extends Person {

    public Faculty (String name, long UUID) {
        super(name, UUID);
        this.setRetTime(7);

    }
}
