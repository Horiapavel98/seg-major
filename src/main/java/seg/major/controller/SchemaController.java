package seg.major.controller;

import java.util.ResourceBundle;
import java.net.URL;
import javafx.fxml.Initializable;

/**
 * SchemaController acts as the controller for the schema.fxml file
 */
public class SchemaController implements Initializable, ViewsController {

  private PrimaryController primaryController;

  /** ---------- FXML ---------- */

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
