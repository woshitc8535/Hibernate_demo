package entity;

public class InstructorDetail {
    private int id;
    private String hobby;

    public InstructorDetail(String hobby) {
        this.hobby = hobby;
    }

    public InstructorDetail() {
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
