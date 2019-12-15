package Controller;

import Enum.AnnouncementType;
import Model.Announcement;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
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
    
    public void initialize() {
        this.createAnnouncementButton.setDisable(true);
        this.comType.setItems(FXCollections.observableArrayList("Exam1","Exam2","Exam3","Exam4","Exam5","Exam6","Exam7","Exam8","Exam9","Exam10","General"));
    }    
    
    @FXML
    public void cancel() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
    
    @FXML
    public void changeAction() {
        if(!(this.titleInput.getText().equals("")) && !(this.comType.getValue() == null) && !(this.descriptionInput.getText().equals("")))
            this.createAnnouncementButton.setDisable(false);
    }
    
    @FXML
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
            this.createAnnouncementButton.setDisable(true);
        }
        else
        {
            this.output.setText("Error");
        }
    }
    
}
