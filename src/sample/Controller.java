package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public TextField textField;

    @FXML
    public Button buttonChange;

    @FXML
    public TextField login;

    @FXML
    public PasswordField pass;

    public void onButtonClicked(){
        System.out.println("Hello "+ textField.getText());
    }

    public void onButtonSecWindow(){
        System.out.println("Witaj na drugim ekranie");
    }

    public void onButtonBye(){
        System.out.println("Bye Bye "+ textField.getText());
    }

    public void newWindow(){
       /* Label secondLabel = new Label("I'm a Label on new Window");
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);
        Scene secondScene = new Scene(secondaryLayout, 230, 100);
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);
        // Set position of second window, related to primary window.
        newWindow.setX(200.0);
        newWindow.setY(100.0);
        newWindow.show();
        System.out.println("new Window");*/
    }


    public void onButtonClickLogin(javafx.event.ActionEvent e) {
        System.out.println("Login = " +login.getText());
        System.out.println("Hasło = " +pass.getText());

        System.out.println("Button Login");


        //DB CONNECTION
        Connection conn = null;
        Statement stmt = null;
        try {
            // db parameters
          //String url = "jdbc:sqlite:C:\\Users\\lzdunows\\Desktop\\UTP\\Java\\database\\db.db";
            String url = "jdbc:sqlite:D:\\Programming\\database\\db.db";

            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS gracze (\n"
                    + "	id integer PRIMARY KEY,\n"
                    + "	login text NOT NULL,\n"
                    + "	pass text not NULL\n"
                    + ");";

            stmt.executeUpdate(sql);
           // String sqll = "INSERT INTO gracze VALUES (1, zdunek, asd)";

           // System.out.println(sqll);

            DatabaseMetaData md = conn.getMetaData();
           // ResultSet rs = md.getTables();

        } catch (SQLException ex) {
            System.out.println("Wystapil error " +ex.getMessage());
        }
    }


    public void onButtonClickRegister(javafx.event.ActionEvent e) {
        String log = login.getText().toString();
        String pas = pass.getText().toString();
        System.out.println("Login = " + log);
        System.out.println("Hasło = " + pas);

        System.out.println("Button Register");

        Connection conn = null;
        Statement stmt = null;
        try {
            // db parameters

            //Baza danych ASUS
            String url = "jdbc:sqlite:D:\\Programming\\database\\db.db";
            //Baza danych HP
            //String url = "jdbc:sqlite:C:\\Users\\lzdunows\\Desktop\\UTP\\Java\\database\\db.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            stmt = conn.createStatement();

           /* String check = "SELECT login FROM gracze WHERE login='"+log+"'";
            System.out.println(stmt.executeUpdate(check));*/

         /*    if(check==log){
                System.out.println("Uzytkownik juz istnieje");
             }else {*/

                String sql = "INSERT OR IGNORE INTO gracze(login, pass) VALUES('" + log + "','" + pas + "')";
                stmt.executeUpdate(sql);
                System.out.println("Uzytkownik dodany");
         //   }

        } catch (SQLException ex) {
            System.out.println("Wystapil error " +ex.getMessage());
        }

    }

    @FXML
    public void changeScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecWindow.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hello World 2");
        stage.setScene(new Scene(root1, 300, 275));
        stage.show();
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private Text status;

    @FXML
    public void displayPosition(MouseEvent e) {
        System.out.println("X = "+ e.getX() + "      Y = "+ e.getY());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}


