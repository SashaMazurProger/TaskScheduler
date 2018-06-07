package core.model.tasks;

public interface Task {

    void start();
    void stop();
    boolean isImmediately();
}
