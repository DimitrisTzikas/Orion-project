package Controller;

import Enum.AnnouncementType;
import Model.Announcement;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAnnouncementCON {
    
    @FXML
    private Button createAnnouncementButton, cancelButton;

    @FXML
    private Label output;

    @FXML
    private TextField titleInput;

    @FXML
    private ComboBox comType;

    @FXML
    private TextArea descriptionInput;
    
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/CreateAnnouncementUI.fxml"));
	Scene scene = new Scene(root);
	stage.setTitle("Create Announcement");
	stage.setScene(scene);
	stage.show();
    }
    
    public void initialize() {
        
        this.comType.setItems(FXCollections.observableArrayList("Exam1","Exam2","Exam3","Exam4","Exam5","Exam6","Exam7","Exam8","Exam9","Exam10","General"));
    }    
    public void cancel() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
    
    public void createAnnouncement() 
    {
        if(Announcement.createAnnouncement(
                    this.titleInput.getText(),
                    AnnouncementType.valueOf((String) this.comType.getValue()), 
                    this.descriptionInput.getText()
                    )
        )
        {
            this.output.setText("Announcement Created");
            this.titleInput.setText("");
            this.comType.setValue("");
            this.descriptionInput.clear();
        }
        else
        {
            this.output.setText("Error");
        }
    }
    
}
