package seg.major.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import seg.major.App;
import seg.major.model.LoginModel;


public class LoginController implements Initializable, ControllerInterface {


    private PrimaryController primaryController;
    private Map<String, Object> data = new HashMap<>();

    /** ---------- FXML ---------- */
    @FXML
    public TextField username;
    @FXML
    public Button loginButton;
    @FXML
    public PasswordField password;
    @FXML
    public VBox parent;
    @FXML
    public ImageView keyImg;
    @FXML
    public ImageView humanImg;

    /**
     * The login button was clicked, so load the patient schema view
     * 
     * @param e click event
     */
    @FXML
    public void loginBtn() {
        if (!username.getText().equals("") && !password.getText().equals("")) {
            if (LoginModel.validateLogin(username.getText(), password.getText())) {
                primaryController.sendTo(App.schema, "user", LoginModel.getUserByUsername(username.getText()));
                primaryController.setPane(App.schema);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Invalid Credentials");
                alert.setHeaderText(null);
                alert.setContentText("Wrong authentication details");

                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Complete all fields!");
            alert.setHeaderText(null);
            alert.setContentText("You must complete all fields provided!");

            alert.showAndWait();
        }
    }

    /** ---------- FXML ---------- */

    /** ---------- Inherited / Implemented ---------- */
    /**
     * Allow javafx to initalise the controller with the view
     */
    public void initialize(URL url, ResourceBundle rb) {
        setGlobalEventHandler(parent);
        humanImg.setImage(new Image("images/humanIcon.png"));
        keyImg.setImage(new Image("images/keyIcon.png"));
    }


    private void setGlobalEventHandler(Node root) {
        root.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
            if (ev.getCode() == KeyCode.ENTER) {
                loginBtn();
                ev.consume();
            }
        });
    }
    /**
     * Set the primaryController
     * 
     * @param primaryController the PrimaryController to set
     */
    public void setScreenParent(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }

    /**
     * Set the data
     * 
     * @param data the data to set
     */
    public void setData(Map<String, Object> toSet) {
        this.data = toSet;
    }

    /**
     * Add data to the given fx-item and update the scene
     * 
     * @param tpAddKey the key of the data
     * @param toAddVal the value of the data
     */
    public void addData(String toAddKey, Object toAddVal) {
        data.put(toAddKey, toAddVal);
        update();
    }

    /**
     * Update the scene with changes from the data HashMap
     */
    public void update() {
    }

    /** ---------- Inherited / Implemented ---------- */

}
