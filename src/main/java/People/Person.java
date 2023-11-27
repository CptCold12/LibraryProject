package People;

public class Person {

    protected String name;
    protected long UUID;

    protected int retTime;
    public Person (String name, long UUID){
        this.name = name;
        this.UUID = UUID;

    }

    public int getRetTime() {
        return retTime;
    }

    public void setRetTime(int retTime) {
        this.retTime = retTime;
    }

    public long getUUID(){
        return UUID;
    }

}
