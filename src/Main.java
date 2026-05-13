import exception.TaskEx;
import model.*;
import service.Repo;
import service.TaskSvc;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Repo<Emp> empRepo = new Repo<>();
        Repo<Task> taskRepo = new Repo<>();

        TaskSvc svc = new TaskSvc();

        // default data
        Emp e1 = new FTEmp(1, "Abhay", 70000);
        Emp e2 = new Intern(2, "Rahul", 20000);
        Emp e3 = new FTEmp(3, "Aman", 90000);

        empRepo.add(e1);
        empRepo.add(e2);
        empRepo.add(e3);

        Task t1 = new Task(101, "Fix Bug", 1);
        Task t2 = new Task(102, "Write Test", 1);
        Task t3 = new Task(103, "Docs", 2);
        Task t4 = new Task(104, "API Work", 3);

        t1.markDone();
        t3.markDone();

        taskRepo.add(t1);
        taskRepo.add(t2);
        taskRepo.add(t3);
        taskRepo.add(t4);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Add Task");
            System.out.println("3. View Employees");
            System.out.println("4. View Tasks");
            System.out.println("5. View Completed Tasks");
            System.out.println("6. Group Tasks By Employee");
            System.out.println("7. Sort Employees By Salary");
            System.out.println("8. Mark Task Done");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:

                    System.out.print("Enter ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("1. Full Time  2. Intern : ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    Emp emp;

                    if (type == 1) {
                        emp = new FTEmp(empId, name, sal);
                    } else {
                        emp = new Intern(empId, name, sal);
                    }

                    empRepo.add(emp);

                    System.out.println("Employee Added");
                    break;

                case 2:

                    System.out.print("Task ID: ");
                    int taskId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Task Title: ");
                    String title = sc.nextLine();

                    System.out.print("Employee ID: ");
                    int eId = sc.nextInt();
                    sc.nextLine();

                    Task task = new Task(taskId, title, eId);

                    try {
                        svc.validate(task);
                        taskRepo.add(task);
                        System.out.println("Task Added");
                    } catch (TaskEx e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:

                    System.out.println("\n=== Employees ===");

                    empRepo.getAll()
                            .forEach(System.out::println);

                    break;

                case 4:

                    System.out.println("\n=== Tasks ===");

                    taskRepo.getAll()
                            .forEach(System.out::println);

                    break;

                case 5:

                    System.out.println("\n=== Completed Tasks ===");

                    List<Task> done = svc.doneTasks(taskRepo.getAll());

                    done.forEach(System.out::println);

                    break;

                case 6:

                    System.out.println("\n=== Grouped Tasks ===");

                    svc.groupByEmp(taskRepo.getAll())
                            .forEach((id, tasks) -> {
                                System.out.println("Emp ID: " + id);
                                tasks.forEach(System.out::println);
                            });

                    break;

                case 7:

                    System.out.println("\n=== Sorted Employees ===");

                    empRepo.getAll()
                            .stream()
                            .sorted(Comparator.comparing(Emp::getSal).reversed())
                            .forEach(System.out::println);

                    break;

                case 8:

                    System.out.print("Enter Task ID to mark done: ");
                    int doneId = sc.nextInt();
                    sc.nextLine();

                    taskRepo.getAll()
                            .stream()
                            .filter(t -> t.getId() == doneId)
                            .findFirst()
                            .ifPresent(Task::markDone);

                    System.out.println("Task Updated");

                    break;

                case 9:

                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
