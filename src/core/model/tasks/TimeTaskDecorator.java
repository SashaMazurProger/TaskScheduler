package core.model.tasks;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTaskDecorator extends BaseTaskDecorator {
    private Date time;
    private Timer timer;

    public TimeTaskDecorator(Task task, Date time) {
        super(task);
        this.time = time;
    }

    @Override
    public void start() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.start();
            }
        }, time);
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public boolean isImmediately() {
        return false;
    }
}
