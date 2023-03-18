package ba.unsa.etf.rpr.controler;

import ba.unsa.etf.rpr.business.KatalogManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Recite;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static ba.unsa.etf.rpr.AppFX.*;
import static ba.unsa.etf.rpr.business.UserManager.CkeckEmail;
import static ba.unsa.etf.rpr.controler.MainControler.*;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;

public class ProfileControler {


    @FXML
      public Label usernameLabel;
    public ListView<String> reciteList;

    public TextField newEmail,newUsername,newPassword;
    public Label ChangeErrorSuccses;
    @FXML
    public void initialize() {
        try {
            usernameLabel.setText(KatalogManager.currentUser.getUsername());
           loadRecite();
        } catch (Exception e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }}

    public void loadRecite() throws Exception {
        List<Recite> rec= DaoFactory.reciteDao().getUserRecite(KatalogManager.currentUser.getId());
        for(Recite recite:rec){
                reciteList.getItems().add(recite.toString());

        }
    }
    public void openHome(ActionEvent actionEvent) throws IOException, SQLException {
        KatalogControler.setSold(false);
            MainHomeScreen();
        }

    public void openSold() throws SQLException {
        KatalogControler.setSold(true);
        MainHomeScreen();

    }

    public void ChangeColor(MouseEvent mouseEvent) {
        MainChangeColor(mouseEvent);

    }

    public void RevertColor(MouseEvent mouseEvent) {
        MainRevertColor(mouseEvent);
    }





    public void changeEmail(ActionEvent actionEvent) throws Exception {
        String s=newEmail.getText();
        if(s.isEmpty()){
            ChangeErrorSuccses.setTextFill(RED);
            ChangeErrorSuccses.setText("Field cant be empty");
        }else  if(CkeckEmail(s)){
            ChangeErrorSuccses.setTextFill(RED);
            ChangeErrorSuccses.setText("Email already registerd");
        }else{
            KatalogManager.currentUser.setEmail(s);
            DaoFactory.userDao().update(KatalogManager.currentUser);

            ChangeErrorSuccses.setTextFill(GREEN);
            ChangeErrorSuccses.setText("Email successfully changed");
            newEmail.clear();
        }

    }

    public void changeUsername(ActionEvent actionEvent) throws Exception {
        String s=newUsername.getText();
        if(s.isEmpty()) {
            ChangeErrorSuccses.setTextFill(RED);
            ChangeErrorSuccses.setText("Field cant be empty");
        }
        else {
            KatalogManager.currentUser.setUsername(s);
            DaoFactory.userDao().update(KatalogManager.currentUser);
            ChangeErrorSuccses.setTextFill(GREEN);
            ChangeErrorSuccses.setText("Username successfully changed");
            usernameLabel.setText(KatalogManager.currentUser.getUsername());
            newUsername.clear();
        }
    }

    public void changePassword(ActionEvent actionEvent) throws Exception {
        String s=newPassword.getText();
        if(s.isEmpty()) {
            ChangeErrorSuccses.setTextFill(RED);
            ChangeErrorSuccses.setText("Field cant be empty");
        }
        else {
            KatalogManager.currentUser.setPassword(s);
            DaoFactory.userDao().update(KatalogManager.currentUser);
            ChangeErrorSuccses.setTextFill(GREEN);
            ChangeErrorSuccses.setText("Password successfully changed");
            newPassword.clear();
        }
    }

}
