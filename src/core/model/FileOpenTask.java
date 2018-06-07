package core.model;

public class FileOpenTask extends Task {
    public FileOpenTask(Builder builder) {
        super(builder);
    }

//    private File file;
//
//    public FileOpenTask(long id, String description, Date createdAt) {
//        super(id, description, createdAt);
//    }
//
//    public FileOpenTask(long id,File file, String description, Date createdAt) {
//        super(id, description, createdAt);
//        this.file = file;
//    }
//
//
//    @Override
//    public void start() {
//        try {
//            //Desktop.getDesktop().open(file);
//            Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void stop() {
//
//    }
}
