package core.model;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Date;

public class Task {



    public enum Command {OPEN_FILE, OPEN_URL}

    private long id;
    private String description;
    private Date createdAt;
    private Command command;
    private File openFile;
    private Date targetTime;
    private String url;

    public Task(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.createdAt = builder.createdAt;
        this.openFile = builder.openFile;
        this.command = builder.command;
        this.targetTime = builder.targetTime;
        this.url=builder.url;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public File getOpenFile() {
        return openFile;
    }

    public void setOpenFile(File openFile) {
        this.openFile = openFile;
    }

    public Date getTargetTime() {
        return targetTime;
    }

    public void setTargetTime(Date targetTime) {
        this.targetTime = targetTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void start() {

        if (command == null) {
            return;
        }

        switch (this.command) {
            case OPEN_FILE:
                if (this.openFile != null) {
                    try {
                        Desktop.getDesktop().open(openFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case OPEN_URL:
                if (this.url != null) {
                    try {
                        Desktop.getDesktop().browse(URI.create(url));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    public void stop() {

    }

    public boolean isImmediatly(){
        if(targetTime==null){
            return true;
        }
        return false;
    }
    public boolean isReady(){
        if(targetTime!=null){
            Date nowTime=new Date();
            if(targetTime.equals(nowTime)){

                return true;
            }
        }
        return false;
    }
    public boolean isScheduled() {
        return !isImmediatly();
    }


    static class Builder {
        private long id;
        private String description;
        private Date createdAt;
        private Command command;
        private File openFile;
        private Date targetTime;
        public String url;

        public Builder(long id, Command command, Date createdAt) {
            this.id = id;
            this.command = command;
            this.createdAt = createdAt;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setOpenFile(File file) {
            this.openFile = file;
            return this;
        }

        public Builder setOpenUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setTargetTime(Date time) {
            this.targetTime = time;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
