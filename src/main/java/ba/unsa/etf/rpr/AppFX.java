package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.controler.LoginControler;
import ba.unsa.etf.rpr.domain.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import static ba.unsa.etf.rpr.controler.MainControler.fxmlLogin;


public class AppFX extends Application {


    public static int ID;

    public static Scene scene;
    public static Stage stage1=new Stage();



    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {


try {



        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLogin);
        LoginControler loginController = new LoginControler();
        fxmlLoader.setController(loginController);
        scene = new Scene(fxmlLoader.load());
        stage1.setTitle("Login");
        stage1.setResizable(false);
        stage1.setScene(scene);
        stage1.show();


}catch (Exception a){
    System.out.println(a);
}
    }



    public static void main(String[] args) {
        launch();
    }
}