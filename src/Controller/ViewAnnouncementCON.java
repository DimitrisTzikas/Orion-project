package Controller;

import Enum.AnnouncementType;
import Model.Announcement;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/ViewAnnouncementUI.fxml"));
	Scene scene = new Scene(root);
	stage.setTitle("Show Announcements");
	stage.setScene(scene);
	stage.show();
    }
    
    public void initialize() 
    {
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type")); 
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        
             
        ObservableList<Announcement> model = FXCollections.observableArrayList(Announcement.getAnnouncement());
        
        tableAnnouncement.setItems(model);
    }
    
    public void exit() {
        ((Stage) exitButton.getScene().getWindow()).close();
    }
    
}
