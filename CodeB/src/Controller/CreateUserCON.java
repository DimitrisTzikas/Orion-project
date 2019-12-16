package Controller;

import Model.Secretariat;
import Model.Student;
import Model.Teacher;
import Model.User;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateUserCON {
    
    @FXML
    private Button cancelButton, createUserButton;
    
    @FXML
    private TextField usernameInput, nameInput, surnameInput, emailInput, phoneNumberInput;
    
    @FXML
    private PasswordField passwordInput;
    
    @FXML
    private ComboBox comDay, comMonth, comYear, comType, comSemester;
    
    @FXML
    private Label outputLabel;
    
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/CreateUserUI.fxml"));
	Scene scene = new Scene(root);
	stage.setTitle("Create User");
	stage.setScene(scene);
	stage.show();
    }

    public void initialize() {
        this.comSemester.setVisible(false);
        
        this.comDay.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"));
        this.comDay.setValue("");
        this.comMonth.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
        this.comMonth.setValue("");
        this.comYear.setItems(FXCollections.observableArrayList("1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"));
        this.comYear.setValue("");
        this.comType.setItems(FXCollections.observableArrayList("Student", "Teacher", "Secretariat"));
        this.comType.setValue("");
        this.comSemester.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        this.comSemester.setValue("");
        
        this.emailInput.setText("");
        this.nameInput.setText("");
        this.outputLabel.setText("");
        this.passwordInput.setText("");
        this.phoneNumberInput.setText("");
        this.surnameInput.setText("");
        this.usernameInput.setText("");
        
        this.createUserButton.setOnAction((ActionEvent event) -> {
            boolean flag = false;
            if(this.comType.getValue().equals("Student")){
                try {
                    flag = User.addUser(new Student(
                            Integer.parseInt((String) this.comSemester.getValue()),
                            this.usernameInput.getText(),
                            this.passwordInput.getText(),
                            this.nameInput.getText(),
                            this.surnameInput.getText(),
                            (new SimpleDateFormat("dd/MM/yyyyyy")).parse((this.comDay.getValue()) + "/" + (this.comMonth.getValue()) + "/" + (this.comYear.getValue())),
                            this.emailInput.getText(),
                            this.phoneNumberInput.getText()
                    ));
                } catch (ParseException ex) {
                }
            }
            else if(this.comType.getValue().equals("Teacher")){
                try {
                    flag = User.addUser(new Teacher(
                            this.usernameInput.getText(),
                            this.passwordInput.getText(),
                            this.nameInput.getText(),
                            this.surnameInput.getText(),
                            (new SimpleDateFormat("dd/MM/yyyyyy")).parse((this.comDay.getValue()) + "/" + (this.comMonth.getValue()) + "/" + (this.comYear.getValue())),
                            this.emailInput.getText(),
                            this.phoneNumberInput.getText()
                    ));
                } catch (ParseException ex) {
                }
            }
            else if(this.comType.getValue().equals("Secretariat")){
                try {
                    flag = User.addUser(new Secretariat(
                            this.usernameInput.getText(),
                            this.passwordInput.getText(),
                            this.nameInput.getText(),
                            this.surnameInput.getText(),
                            (new SimpleDateFormat("dd/MM/yyyyyy")).parse((this.comDay.getValue()) + "/" + (this.comMonth.getValue()) + "/" + (this.comYear.getValue())),
                            this.emailInput.getText(),
                            this.phoneNumberInput.getText()
                    ));
                } catch (ParseException ex) {
                }
            }
            
            if(flag){
                this.outputLabel.setText("User added");
                this.outputLabel.setStyle("-fx-background-color: none");
                this.initialize();
                
            }
            else{
                this.outputLabel.setText("Something is wrong");
                this.outputLabel.setStyle("-fx-background-color: #ff8888");
            }

        });
        
    }    
    
    @FXML
    public void checkType() {
        try{
            this.comSemester.setVisible(this.comType.getValue().equals("Student"));
        } catch(Exception e){
            this.comSemester.setVisible(false);
        }
    }
    
    @FXML
    public void cancel(){
        ((Stage) cancelButton.getScene().getWindow()).close();
    }
    
}
