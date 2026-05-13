package model;

public class FTEmp extends Emp {

    public FTEmp(int id, String name, double sal) {
        super(id, name, sal);
    }

    @Override
    public void work() {
        System.out.println(getName() + " working full-time.");
    }

    @Override
    public String getRole() {
        return "FTE";
    }
}
