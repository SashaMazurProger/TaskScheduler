package view;

import core.model.Manager;
import javafx.fxml.FXML;

public class RootLayoutController {
    @FXML
    public void startr(){
        Manager manager=new Manager();
        manager.start();
    }
}
