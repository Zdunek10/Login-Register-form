package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerGame implements Initializable {

    //ControllerSecWind ControllerSecWind = new ControllerSecWind();


    public void start(Stage primaryStage) throws Exception {
      /*  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sampleGame.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Controller Game Class");
        stage.setScene(new Scene(root1, 300, 275));
        stage.show();

        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();*/

        System.out.println("Gra rozpoczeta w Controller Game Class");
    }

    private void drawShapes(GraphicsContext gc) {

     /*  // ControllerSecWind.getClass().

        Rectangle r = new Rectangle();
        gc.fillOval(10, 60, 30, 30);
        r.setX(50);
        r.setY(50);
        r.setWidth(200);
        r.setHeight(100);
        r.setArcWidth(20);
        r.setArcHeight(20);
*/
    }

    @FXML
    private Text status;

    @FXML
    public void displayPostition(KeyEvent e) {
        status.setText("X = "+ status.getX() + "      Y = "+ status.getY());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
