package core.model.tasks;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class OpenUrlTask implements Task {

    protected String url;

    public OpenUrlTask(String url) {
        this.url = url;
    }

    @Override
    public void start() {
        try {
            Desktop.getDesktop().browse(URI.create(url));
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
