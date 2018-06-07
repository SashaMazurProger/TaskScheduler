package core.model;

import core.model.tasks.Task;

import java.util.List;

public interface Repository {
    List<Task> getAllTasks();
}
