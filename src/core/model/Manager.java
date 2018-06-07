package core.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    private Repository repository;
    private List<Task> allTasks;
    private ScheduledTasksWatcher scheduledTasksWatcher;

    public void start(){

        initAllTasks();
        startImmediatlyTasks();
        startScheduledTasks();
    }

    private void startScheduledTasks() {
        scheduledTasksWatcher=new ScheduledTasksWatcher();
        List<Task> tasks=getScheduledTasks();
        scheduledTasksWatcher.setScheduledTasks(tasks);
        scheduledTasksWatcher.startWatch();
    }

    private void startImmediatlyTasks() {
        List<Task> tasks=getImmediatlyTasks();
        if(!tasks.isEmpty()){
            for(Task t:tasks){
                t.start();
            }
        }
    }

    private void initAllTasks() {
        repository=new RepositoryImp();
        allTasks=repository.getAllTasks();
    }
    private List<Task> getImmediatlyTasks(){
        List<Task> response=new ArrayList<>();

        for(Task task:allTasks){
            if(task.isImmediatly()){
                response.add(task);
            }
        }
        return response;
    }
    private List<Task> getScheduledTasks(){
        List<Task> response=new ArrayList<>();

        for(Task task:allTasks){
            if(task.isScheduled()){
                response.add(task);
            }
        }
        return response;
    }
}
