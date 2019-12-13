package Controller;

import Enum.AnnouncementType;
import Model.Announcement;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewAnnouncementCON {
    
    @FXML
    private Button exitButton;
    
    @FXML
    private TableView<Announcement> tableAnnouncement;
    
    @FXML
    private TableColumn<Announcement, String> descriptionCol, titleCol, authorCol;
    
    @FXML
    private TableColumn<Announcement, AnnouncementType> typeCol;
    
    public void initialize() 
    {
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type")); 
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableAnnouncement.setItems(FXCollections.observableArrayList(Announcement.getAnnouncement()));
    }
    
    public void exit() {
        ((Stage) exitButton.getScene().getWindow()).close();
    }
    
}
