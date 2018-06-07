package core.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class RepositoryImp implements Repository{

    @Override
    public List<Task> getAllTasks() {

        List<Task> allTasks=new ArrayList<>(Arrays.asList(

                new Task.Builder(1, Task.Command.OPEN_FILE, new Date())
                        .setOpenFile(new File("C:\\Program Files\\IObit\\Advanced SystemCare\\ASC.exe"))
                        .build(),

                new Task.Builder(2, Task.Command.OPEN_URL, new Date())
                        .setOpenUrl("https://google.com")
                        .build()
        ));

        return allTasks;
    }
}
