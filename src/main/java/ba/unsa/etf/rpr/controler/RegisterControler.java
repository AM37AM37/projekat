package ba.unsa.etf.rpr.controler;

import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static ba.unsa.etf.rpr.AppFX.*;
import static ba.unsa.etf.rpr.business.UserManager.*;

public class RegisterControler {
    private  void  LoginScreen() {
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
    @FXML
    TextField EmailReg,PassReg,UsernameReg;
    @FXML
    Text RegisterError;
    public void onRegisterButtonClick() throws Exception {
        String Email = EmailReg.getText();
        String Pass = PassReg.getText();
        String Username = UsernameReg.getText();
        User newuser =new User(Username,Pass,Email);

        if (CkeckEmail(Email)) {
            RegisterError.setText("email already registerd");
        } else {
            try {
                AddAcc(newuser);
                LoginScreen();
            } catch (Exception a) {
                System.out.println(a);
            }
        }

    }

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        LoginScreen();
    }


}
