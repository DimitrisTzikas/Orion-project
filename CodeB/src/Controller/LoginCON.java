package Controller;

import Model.Main;
import Model.User;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginCON {
    
    @FXML
    TextField usernameInput;
    
    @FXML
    PasswordField passwordInput;
    
    @FXML
    Button loginButton, exitButton;
    
    @FXML
    Label labelOutput;
    
    public void Start(Stage stage) throws IOException {
	Parent root = FXMLLoader.load(getClass().getResource("/View/LoginUI.fxml"));
	Scene scene = new Scene(root);
	stage.setTitle("Orion - Login");
	stage.setScene(scene);
	stage.show();
    }
    
    public void initialize() {
        
        loginButton.setOnAction((ActionEvent event) -> {
            if(User.login(usernameInput.getText(), passwordInput.getText())) {
                try {
                    Main.startMain(usernameInput.getText());
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                ((Stage) loginButton.getScene().getWindow()).close();
            }
            else {
                loginButton.setStyle("-fx-background-color: #ff8888");
                labelOutput.setText("Wrong username or password");
            }
        });
        
        exitButton.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        
    }
    
}
