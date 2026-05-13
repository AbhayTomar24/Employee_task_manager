package model;

import interfaces.Work;

public abstract class Emp implements Work {

    private int id;
    private String name;
    private double sal;

    public Emp(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return id + " | " + name + " | " + getRole() + " | Salary: " + sal;
    }
}
