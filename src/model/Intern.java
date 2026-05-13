package model;

public class Intern extends Emp {

    public Intern(int id, String name, double sal) {
        super(id, name, sal);
    }

    @Override
    public void work() {
        System.out.println(getName() + " learning.");
    }

    @Override
    public String getRole() {
        return "Intern";
    }
}
