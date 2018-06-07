package core.model;

import core.model.tasks.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class RepositoryImp implements Repository {

    @Override
    public List<Task> getAllTasks() {

        Task openFile = new FileOpenTask(new File("C:\\Program Files\\IObit\\Advanced SystemCare\\ASC.exe"));
        openFile = new TimeTaskDecorator(openFile, new Date(new Date().getTime() + 10000));

        Task shutdn = new PcPowerTask(PcPowerTask.TYPE.SHUTDOWN, 5);
        List<Task> allBaseTasks = new ArrayList<>(Arrays.asList(
                openFile,
                shutdn
        ));

        return allBaseTasks;
    }
}
