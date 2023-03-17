package ba.unsa.etf.rpr.controler;

import ba.unsa.etf.rpr.business.KatalogManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static ba.unsa.etf.rpr.AppFX.*;
import static ba.unsa.etf.rpr.business.UserManager.*;

public class LoginControler {


    private void HomeScreen () {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlKatalog);
            KatalogControler katalogController = new KatalogControler();
            fxmlLoader.setController(katalogController);
            scene = new Scene(fxmlLoader.load());
            stage1.setTitle("MainCatalog");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();

        }catch (Exception a){
            System.out.println(a);
        }
    }

    private void RegisterScreen() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlRegister);
            RegisterControler registerController = new RegisterControler();
            fxmlLoader.setController(registerController);
            scene = new Scene(fxmlLoader.load());
            stage1.setTitle("Register");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        }catch (Exception a){
            System.out.println(a);
            throw a;
        }
    }


    @FXML
    private Text LoginError, RegisterError;
    @FXML
    private TextField EmailField, PassField, EmailReg, PassReg, UsernameReg;


    @FXML


    public void onLoginButtonClick() throws Exception {
        String Email = EmailField.getText();
        String Pass = PassField.getText();
        String PassProv = GetPassByEmail(Email);
        System.out.println(PassProv);
        if (PassProv.equals(Pass)) {
            KatalogManager.currentUser=GetUserByEmail(Email);
            HomeScreen();
        } else {
            LoginError.setText("Login not successful");
        }
    }

    public void onSignUpButtonClick(ActionEvent actionEvent) throws IOException {
        RegisterScreen();
    }
















}
