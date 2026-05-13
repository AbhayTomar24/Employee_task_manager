package service;

import exception.TaskEx;
import model.Task;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskSvc {

    public void validate(Task t) throws TaskEx {

        if (t.getTitle() == null || t.getTitle().isBlank()) {
            throw new TaskEx("Task empty");
        }
    }

    public List<Task> doneTasks(List<Task> tasks) {

        return tasks.stream()
                .filter(Task::isDone)
                .toList();
    }

    public Map<Integer, List<Task>> groupByEmp(List<Task> tasks) {

        return tasks.stream()
                .collect(Collectors.groupingBy(Task::getEmpId));
    }

    public List<Task> sortByTitle(List<Task> tasks) {

        return tasks.stream()
                .sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))
                .toList();
    }
}
