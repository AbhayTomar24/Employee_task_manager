package model;

public class Task {

    private int id;
    private String title;
    private boolean done;
    private int empId;

    public Task(int id, String title, int empId) {
        this.id = id;
        this.title = title;
        this.empId = empId;
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public int getEmpId() {
        return empId;
    }

    public void markDone() {
        done = true;
    }

    @Override
    public String toString() {
        return id + " | " + title +
                " | Emp ID: " + empId +
                " | Done: " + done;
    }
}
