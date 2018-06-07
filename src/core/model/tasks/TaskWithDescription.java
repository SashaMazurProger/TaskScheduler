package core.model.tasks;

import java.util.Date;

public class TaskWithDescription implements Task{
    
    private String title;
    private long createdAt;

    public TaskWithDescription(String title, long createdAt) {
        this.title = title;
        this.createdAt = createdAt;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isImmediately() {
        return false;
    }


//    static class Builder {
//        private long id;
//        private String description;
//        private Date createdAt;
//
//        public String url;
//
//
//
//        public Builder setDescription(String description) {
//            this.description = description;
//            return this;
//        }
//
//        public Builder setOpenUrl(String url) {
//            this.url = url;
//            return this;
//        }
//
//        public BaseTask build() {
//            return new BaseTask(this);
//        }
//    }
}
