package seg.major.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.HashMap;

/**
 * PrimaryController is the mains views controller, it works by storing a
 * HashMap (panes in this case) that can be set as the active content in a
 * window very easily. Each view contoller (that is - any files which have a
 * .fxml in the resouorces folder) will need to inject *this* PrimaryController
 * in order to change windows.
 */
public class PrimaryController extends StackPane {

  private HashMap<String, Node> panes = new HashMap<>();

  public PrimaryController() {
    super();
  }

  /**
   * Add an array of views from the views folder to the controller
   * 
   * @param toAdd array of names of views to add
   */
  public void addViews(String[] toAdd) {
    for (String s : toAdd) {
      addPane(s, loadView(s));
    }
  }

  /**
   * Loads a view from the views resource folder
   * 
   * @param toAdd array of names of views to add
   * @return the loadedNode
   */
  private Node loadView(String toLoad) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/" + toLoad + ".fxml"));
      Parent toReturn = (Parent) loader.load();
      ViewsController vc = ((ViewsController) loader.getController());
      vc.setScreenParent(this);
      return toReturn;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Adds a pane to the controller
   * 
   * @param name name of the pane to add
   * @param pane the pane to add
   */
  public void addPane(String name, Node pane) {
    panes.put(name, pane);
  }

  /**
   * Adds a pane to the controller
   * 
   * @param name name of the pane to set
   * @return was the operation successful?
   */
  public boolean setPane(String name) {
    VBox n;
    if (panes.get(name) != null) {
      n = (VBox) panes.get(name);
      if (!getChildren().isEmpty()) {
        getChildren().remove(0);
        getChildren().add(0, n);

      } else {
        getChildren().add(n);

      }
      setMinSize(n.prefWidth(-1), n.prefHeight(-1));
      return true;
    } else {
      System.out.println("screen hasn't been loaded!!! \n");
      return false;
    }
  }
}