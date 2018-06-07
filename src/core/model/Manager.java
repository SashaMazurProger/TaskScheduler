package core.model;

import core.model.tasks.Task;
import core.model.tasks.TaskWithDescription;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    private Repository repository;
    private List<Task> allBaseTasks;


    public void start(){

        initAllTasks();
        startImmediatlyTasks();
        startScheduledTasks();
    }

    private void startScheduledTasks() {
        List<Task> baseTasks =getScheduledTasks();
        if(!baseTasks.isEmpty()){
            for(Task t: baseTasks){
                t.start();
            }
        }
    }

    private void startImmediatlyTasks() {
        List<Task> baseTasks =getImmediatlyTasks();
        if(!baseTasks.isEmpty()){
            for(Task t: baseTasks){
                t.start();
            }
        }
    }

    private void initAllTasks() {
        repository=new RepositoryImp();
        allBaseTasks =repository.getAllTasks();
    }
    private List<Task> getImmediatlyTasks(){
        List<Task> response=new ArrayList<>();

        for(Task baseTask : allBaseTasks){
            if(baseTask.isImmediately()){
                response.add(baseTask);
            }
        }
        return response;
    }
    private List<Task> getScheduledTasks(){
        List<Task> response=new ArrayList<>();

        for(Task baseTask : allBaseTasks){
            if(!baseTask.isImmediately()){
                response.add(baseTask);
            }
        }
        return response;
    }
}
