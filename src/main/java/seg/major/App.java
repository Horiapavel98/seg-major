/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package seg.major;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import seg.major.controller.PrimaryController;
import seg.major.model.util.Props;

public class App extends Application {

    // Name of the view that is shown on first loading the application
    public static String login = "login";
    public static String addPatient = "add_patient";
    public static String updatePatient = "update_patient";
    public static String updateAppointment = "update_appointment";
    public static String contacts = "contacts";
    public static String patients = "patients";
    public static String schema = "schema";
    public static String notifyList = "notifyList";
    public static String propertiesLocation = "props.properties";
    public static String customEmail = "custom_email";
    public static Props props;

    public static void main(String[] args) {
        System.out.println("App Started!");
        props = new Props(App.class.getClassLoader().getResource(propertiesLocation));
        launch(args);
    }

    /**
     * Start the GUI and load panes
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        PrimaryController primaryController = new PrimaryController(primaryStage);
        primaryController.addViews(
                new String[] { login, notifyList, addPatient, customEmail, patients, schema, contacts, updatePatient, updateAppointment });
        primaryController.setPane(App.login);

        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().addAll(primaryController);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

    }
}
