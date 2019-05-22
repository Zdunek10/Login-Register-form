package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;


public class ControllerSecWind extends ControllerGame{


    @FXML
    public Button start; // po ID

    @FXML
    public Button wyniki; //po ID

    @FXML
    public Button buttonWyjscie; //po ID


    Button btUp = new Button("UP");
    Button btDown = new Button("DOWN");
    Button btLeft = new Button("LEFT");
    Button btRight = new Button("RIGHT");

    @FXML
    private Text status;




    @FXML
    public void buttonStart(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sampleGame.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Okno Gra");
        stage.setScene(new Scene(root1, 300, 275));
        stage.show();
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();

        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();

        System.out.println("Gra rozpoczeta");
    }


    @FXML
    public void displayPosition(MouseEvent e){
        status.setText("X = "+e.getX() + "    Y = "+e.getY());
    }

    @FXML
    private void drawShapes(GraphicsContext gc) {


        Rectangle r = new Rectangle();
        gc.fillOval(10, 60, 30, 30);
        r.setX(50);
        r.setY(50);
        r.setWidth(200);
        r.setHeight(100);
        r.setArcWidth(20);
        r.setArcHeight(20);



     /*   gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);*/
    }

    public void moveShape(){


    }



    @FXML
    public void buttonWyniki(){  // po onAction
        System.out.println("Wyniki wyswietlone");

    }



    @FXML
    public void buttonExit(){
        Stage stage = (Stage) buttonWyjscie.getScene().getWindow();
        stage.close();

    }


}



