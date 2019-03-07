package seg.major.controller;


import java.util.ResourceBundle;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import seg.major.App;
import seg.major.model.LoginModel;
import seg.major.structure.User;

import javax.swing.*;


public class LoginController implements Initializable, ViewsController {

    private PrimaryController primaryController;

    @FXML
    public TextField username;
    @FXML
    public Button loginButton;
    @FXML
    public PasswordField password;

    /**
     * The login button was clicked, so load the patient schema view
     * 
     * @param e click event
     */
    @FXML
    public void loginBtn() {
        if (!username.getText().equals("") && !password.getText().equals("")) {
            if (LoginModel.validateUser(username.getText(), password.getText())) {
                User userAuthenticated = new User(username.getText(),null,password.getText());

                SchemaController sc = (SchemaController) primaryController.getControllerByName(App.schema);

                sc.setData(userAuthenticated);

                primaryController.setPane(App.schema);

                sc.setAuthenticatedUser();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Invalid credentials", "Wrong username/password", JOptionPane.NO_OPTION);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Complete all fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
      
    /** ---------- FXML ---------- */

    /** ---------- Inherited / Implemented ---------- */
    /**
     * Allow javafx to initalise the controller with the view
     */
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Set the primaryController
     * 
     * @param primaryController the PrimaryController to set
     */
    public void setScreenParent(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }
    /** ---------- Inherited / Implemented ---------- */

    
}
