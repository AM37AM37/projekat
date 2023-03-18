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
import static ba.unsa.etf.rpr.controler.MainControler.MainHomeScreen;
import static ba.unsa.etf.rpr.controler.MainControler.MainRegisterScreen;

public class LoginControler {





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
            MainHomeScreen();
        } else {
            LoginError.setText("Login not successful");
        }
    }

    public void onSignUpButtonClick(ActionEvent actionEvent) throws IOException {
        MainRegisterScreen();
    }
















}
