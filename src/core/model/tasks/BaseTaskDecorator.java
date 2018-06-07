package core.model.tasks;

public class BaseTaskDecorator implements Task {

    protected Task task;

    public BaseTaskDecorator(Task task) {
        this.task = task;
    }

    @Override
    public void start() {
        task.start();
    }

    @Override
    public void stop() {
        task.stop();
    }

    @Override
    public boolean isImmediately() {
        return task.isImmediately();
    }
}
