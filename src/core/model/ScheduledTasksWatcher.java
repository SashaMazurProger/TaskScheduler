package core.model;

import java.util.ArrayList;
import java.util.List;

public class ScheduledTasksWatcher {
    private static final long CHECK_INTERVAL_MILLIS = 500;
    private List<? extends Task> scheduledTasks=new ArrayList<>();
    private Thread thread;

    public ScheduledTasksWatcher(List<? extends Task> scheduledTasks) {
        this.scheduledTasks = scheduledTasks;
    }

    public ScheduledTasksWatcher() {
    }

    public void setScheduledTasks(List<? extends Task> scheduledTasks) {
        this.scheduledTasks = scheduledTasks;
    }

    public void startWatch(){
        if(scheduledTasks==null){
            return;
        }

        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
//                    try {
//                        Thread.sleep(CHECK_INTERVAL_MILLIS);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    for (Task t:scheduledTasks){
                        if(t.isReady()){
                            t.start();
                        }
                    }
                }
            }
        });

        thread.start();
    }
    public void stopWatch(){

        if(thread.isAlive()){
            thread.stop();
        }
    }
}
