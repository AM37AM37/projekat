package ba.unsa.etf.rpr.controler;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Katalog;
import ba.unsa.etf.rpr.domain.Recite;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;

import static ba.unsa.etf.rpr.AppFX.*;
import static ba.unsa.etf.rpr.business.KatalogManager.*;
import static ba.unsa.etf.rpr.controler.KatalogControler.*;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;

public class ArticleControler {
    private void ProfileScreen(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlProfile);
            ProfileControler profileController = new ProfileControler();
            fxmlLoader.setController(profileController);
            scene = new Scene(fxmlLoader.load());
            stage1.setTitle("Profile");
            stage1.setScene(scene);
            stage1.setResizable(false);
            //usernameLabel.setText(getUsername(userID));
            stage1.show();
        }catch (Exception a){
            System.out.println(a);
        }
    }

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

    @FXML
    public Text articleName, articleClass, articlePrice, articleDiscription,purchaseErrorSucsses,articleAmount;
    @FXML
    public ImageView articleImage;
    @FXML
    public TextField purchaseAmount;
    @FXML
    public Label usernameLabel;
    private Katalog art;
    @FXML
    public void initialize() throws Exception {
        usernameLabel.setText(currentUser.getUsername());
        ArticleLoader();
    }
    public void ArticleLoader() throws Exception {
        art=DaoFactory.katalogDao().getById(getarticleID());
        articleName.setText(art.getTankName());
        articleClass.setText(art.getTankClass());
        articlePrice.setText(String.valueOf(art.getPrice()));
        articleImage.setImage(BlobToImage(art.getTankImage()));
        articleDiscription.setText((art.getDescription()));
        articleAmount.setText(art.getTankAmount() +" left in stock");
    }


    public void ChangeColor(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setTextFill(RED);

    }

    public void RevertColor(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        btn.setTextFill(Color.WHITE);
    }

    public void openHome(ActionEvent actionEvent) throws IOException, SQLException {
        KatalogControler.setSold(false);
        HomeScreen();
    }


    public void articlePurchase(ActionEvent actionEvent) throws Exception {
        try {
            int amount= getAmount();
            if(amount>art.getTankAmount()){
                purchaseErrorSucsses.setFill(RED);
                purchaseErrorSucsses.setText("amount greater than stock");

            }else if(amount!=0) {
                Recite r =new Recite(currentUser.getId(), art.getId(),amount,amount*art.getPrice(),art.getTankName());
                purchaseArticle(r);
                purchaseErrorSucsses.setFill(GREEN);
                purchaseErrorSucsses.setText("purchase successful");
                setArticleAmount(getarticleID());
            }else {
                purchaseErrorSucsses.setFill(RED);
                purchaseErrorSucsses.setText("incorrect amount input");

            }
        }catch (Exception e){
            purchaseErrorSucsses.setFill(RED);
            purchaseErrorSucsses.setText("purchase failed");
            System.out.println(e);
            throw e;

        }
    }

    public void setArticleAmount(int id) throws Exception {
        if(DaoFactory.katalogDao.getById(getarticleID()).getTankAmount()!=0) {
            articleAmount.setText(DaoFactory.katalogDao.getById(getarticleID()).getTankAmount() + " left in stock");
        }else{
            articleAmount.setFill(RED);
            articleAmount.setText("out of stock");
        }
    }

    public int getAmount(){
        String s=purchaseAmount.getText();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9' ){
                //throwError
                return 0;
            }

        }
        return Integer.parseInt(s);
    }



    public void openProfile(ActionEvent actionEvent) {
        ProfileScreen();
    }




        public void openSold() throws SQLException {
        KatalogControler.setSold(true);
            HomeScreen();

    }
}
