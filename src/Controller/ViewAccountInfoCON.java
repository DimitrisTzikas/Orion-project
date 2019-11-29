package Controller;

import Model.Main;
import Model.Student;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ViewAccountInfoCON {
    
    @FXML
    Button exitButton;
    
    @FXML
    Label labelUsername, labelName, labelSurname, labelBirthday, labelEmail, labelPhoneNumber,labelRegistration, labelSemester, labelSemester2;
    
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/ViewAccountInfoUI.fxml"));
	Scene scene = new Scene(root);
	stage.setTitle("Show Account Information");
	stage.setScene(scene);
	stage.show();
    }
    
    public void initialize() {
        
        // TODO change main to MainCON
        
        this.labelUsername.setText(Main.user.getUsername());
        this.labelName.setText(Main.user.getName());
        this.labelSurname.setText(Main.user.getSurname());
        this.labelBirthday.setText(new SimpleDateFormat("dd/MM/yyyy").format(Main.user.getBirthday()));
        this.labelEmail.setText(Main.user.getEmail());
        this.labelPhoneNumber.setText(Main.user.getPhoneNumber());
        this.labelRegistration.setText(new SimpleDateFormat("dd/MM/yyyy").format(Main.user.getRegistration()));
        if(Main.user instanceof Student){
            this.labelSemester.setText(((Student)Main.user).getSemester()+"");
            this.labelSemester.setVisible(true);
            this.labelSemester2.setVisible(true);
        }
    }
    
    public void exit() {
        ((Stage) exitButton.getScene().getWindow()).close();
    }
    
}
