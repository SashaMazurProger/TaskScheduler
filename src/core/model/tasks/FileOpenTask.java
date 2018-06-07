package core.model.tasks;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileOpenTask implements Task {
    protected File file;

    public FileOpenTask(File file) {
        this.file = file;
    }

    @Override
    public void start() {
        try {
            Desktop.getDesktop().open(file);
            //Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isImmediately() {
        return false;
    }
}
