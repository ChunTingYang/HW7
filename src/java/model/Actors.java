package model;


public class Actors {
    
    private int actorID;
    private String actorName;
    private String nationality;
    private int age;
    private String birthday;
    
    public Actors() {
        this.actorID = 0;
        this.actorName = "";
        this.nationality = "";
        this.age = 0;
        this.birthday = "";
    }
    
    public Actors(int actorID, String actorName, String nationality, int age, String birthday) {
        this.actorID = actorID;
        this.actorName = actorName;
        this.nationality = nationality;
        this.age = age;
        this.birthday = birthday;
    }

    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Actors{" + "actorID=" + actorID + ", actorName=" + actorName + ", nationality=" + nationality + ", age=" + age + ", birthday=" + birthday + '}';
    }
    
    
    
    
}
