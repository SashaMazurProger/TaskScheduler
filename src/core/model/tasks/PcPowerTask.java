package core.model.tasks;

import java.io.IOException;

public class PcPowerTask implements Task {
    public enum TYPE{SHUTDOWN,RESTART,SLEEP,DEEP_SLEEP}
    protected TYPE type;
    private int doAfterSeconds;

    public PcPowerTask(TYPE type, int doAfterSeconds) {
        this.type = type;
        this.doAfterSeconds = doAfterSeconds;
    }

    @Override
    public void start() {
        String timePostfix=null;
        if(doAfterSeconds!=0){
            timePostfix=String.format(" -t %d",doAfterSeconds);
        }

        switch (type){
            case DEEP_SLEEP:
                try {
                    Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case SLEEP:
                //
                break;
            case SHUTDOWN:
                String shutdownCmd = "shutdown -s";
                if(timePostfix!=null){
                    shutdownCmd=shutdownCmd.concat(timePostfix);
                }
                try {
                    Process process=Runtime.getRuntime().exec(shutdownCmd);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case RESTART:
                String restartCmd = "shutdown -r";
                try {
                    Process process=Runtime.getRuntime().exec(restartCmd);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
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
