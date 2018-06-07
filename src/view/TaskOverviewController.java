package view;

import core.model.Manager;
import javafx.fxml.FXML;

public class TaskOverviewController {

    @FXML
    public void start(){
        Manager manager=new Manager();
        manager.start();
    }
}
