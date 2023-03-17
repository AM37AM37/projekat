//package ba.unsa.etf.rpr;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Vector;
//
//import static ba.unsa.etf.rpr.DataConnection.*;
//import static javafx.application.Application.launch;
//import static javafx.scene.paint.Color.GREEN;
//import static javafx.scene.paint.Color.RED;
//
//public class MainControler  {
//
//
//
//
//
//
//
//  //  public abstract class SceneController extends Application {
//
//
//        public static Scene scene;
//        public static Stage stage1=new Stage();
//        // public double h,w;
//        //public ImageView nuke;
//
//
//
//        public static void SetStage(Stage stage){
//            stage1=stage;
//        }

//        public static void  LoginScreen() throws IOException {
//
//            FXMLLoader fxmlLoader = new FXMLLoader(ba.unsa.etf.rpr.MainControler.class.getResource("login.fxml"));
//            scene = new Scene(fxmlLoader.load());
//            stage1.setTitle("Login");
//            stage1.setResizable(false);
//            stage1.setScene(scene);
//            stage1.show();
//
//
//
//        }

        //otvara scenu ipokrece loader
//        public void HomeScreen (boolean sold) {
//            try{
//
//
//                 FXMLLoader fxmlLoader = new FXMLLoader(AppFX.class.getResource("katalog.fxml"));
//                fxmlLoader.setController(this);
//                scene = new Scene(fxmlLoader.load());
//                stage1.setTitle("MainCatalog");
//                stage1.setScene(scene);
//                stage1.setResizable(false);
//                stage1.show();
//                badHomeLoader(sold);
//
//
//
//            }catch (Exception a){
//                System.out.println(a);
//            }
//
//        }



//        public void RegisterScreen() {
//            try {
//                FXMLLoader fxmlLoader = new FXMLLoader(ba.unsa.etf.rpr.MainControler.class.getResource("register.fxml"));
//                scene = new Scene(fxmlLoader.load());
//                stage1.setTitle("Register");
//                stage1.setScene(scene);
//                stage1.setResizable(false);
//                stage1.show();
//            }catch (Exception a){
//                System.out.println(a);
//            }
//        }

//        public void openArticleScene(){
//            try {
//                FXMLLoader fxmlLoader = new FXMLLoader(AppFX.class.getResource("article.fxml"));
//                fxmlLoader.setController(this);
//                scene = new Scene(fxmlLoader.load());
//                stage1.setTitle("CatalogItem");
//                stage1.setScene(scene);
//                stage1.setResizable(false);
//                stage1.show();
//                usernameLabel.setText(getUsername(userID));
//
//                badArticleLoader(null);
//            }catch (Exception a){
//                System.out.println(a);
//            }
//        }

//        public void ProfileScreen(){
//            try{
//                FXMLLoader fxmlLoader = new FXMLLoader(ba.unsa.etf.rpr.MainControler.class.getResource("profile.fxml"));
//                fxmlLoader.setController(this);
//                scene = new Scene(fxmlLoader.load());
//                stage1.setTitle("Profile");
//                stage1.setScene(scene);
//                stage1.setResizable(false);
//                usernameLabel.setText(getUsername(userID));
//                loadRecite();
//                stage1.show();
//            }catch (Exception a){
//                System.out.println(a);
//            }
//        }

    //}
















    //public class  KatalogController {


//    @FXML
//    private Button homeButton, myCatalogButton, profileButton, openArticle;
//
//    @FXML
//    public Label tankName1, tankClass1, tankPrice1, tankName2, tankClass2, tankPrice2, tankName3, tankClass3, tankPrice3;
//    @FXML
//    public Label tankName4, tankClass4, tankPrice4, tankName5, tankClass5, tankPrice5, tankName6, tankClass6, tankPrice6;
//    @FXML
//    public Label tankName7, tankClass7, tankPrice7, tankName8, tankClass8, tankPrice8, tankName9, tankClass9, tankPrice9;
//    @FXML
//    public Label tankID1, tankID2, tankID3, tankID4, tankID5, tankID6, tankID7, tankID8, tankID9;
//    @FXML
//    public ImageView tankImage1, tankImage2, tankImage3, tankImage4, tankImage5, tankImage6, tankImage7, tankImage8, tankImage9;
//    @FXML
//    public Label usernameLabel, noMoreLoad;
//    public Vector<Integer> loadedTanksId = new Vector<>();
//    public int userID = 0, articleID = 0;
//    public boolean MoreLoad = true;
//    public static boolean PreviusLoad = false;
//    public void resetMoreLoad(){
//        MoreLoad=true;
//    }
//
//    public void setUserID() {
//        userID = getID();
//    }
//
////        public void ChangeColor(MouseEvent mouseEvent) {
////            Button btn = (Button) mouseEvent.getSource();
////            btn.setTextFill(Color.RED);
////
////        }
//
////        public void RevertColor(MouseEvent mouseEvent) {
////            Button btn = (Button) mouseEvent.getSource();
////            btn.setTextFill(Color.WHITE);
////        }
//
//
//    public void OpenArticle(ActionEvent actionEvent) throws SQLException, IOException {
//        Object obj = actionEvent.getSource();
//        String s = obj.toString();
//        System.out.println(s);
//        int ID = s.charAt(21) - 49;
//        openArticleScene();
//        articleID = loadedTanksId.elementAt(ID);
//        badArticleLoader(null);
//    }
//
//    public int getarticleID() {
//        return articleID;
//    }
//
////        public void openHome(ActionEvent actionEvent) throws IOException, SQLException {
////            HomeScreen();
////            resetTankID();
////        }
//
//
//
//
//    boolean Sold;
//    public void setSold(boolean sold){
//        Sold=sold;
//    }
//    public void loadeHomeArticle(Label Name, Label Class, Label Price, ImageView Image, Label ID, boolean sold) throws SQLException, IOException {
//        if (nextTankID()) {
//            while((getTankAmount()==0)==sold)
//                if(!nextTankID()) {
//                    MoreLoad = false;
//                    Name.setText("");
//                    Class.setText("");
//                    Price.setText("");
//                    Image.setImage(null);
//                    return;
//                }
//            Name.setText(getTankName());
//            Class.setText(getTankClass());
//            Price.setText(String.valueOf(getTankPrice()));
//            Image.setImage(getTankImage());
//            loadedTanksId.add(getTankID());
//            ID.setText(String.valueOf(getTankID()));
//            MoreLoad = true;
//        } else {
//            MoreLoad = false;
//            Name.setText("");
//            Class.setText("");
//            Price.setText("");
//            Image.setImage(null);
//        }
//    }
//
//    //ucitava sve
//    public void badHomeLoader(boolean sold) throws SQLException, IOException {
//        //postavlja da li cemo ucitat rasprodane ili ne
//            setSold(sold);
//            //MoreLoad je provjera ima li jos da ucita, ako nema postavlja label na "No more..."
//            if (MoreLoad) {
//                //ucita userID is DataControlera Classe i sacuva ga u ovoj klasi
//                setUserID();
//                //ucitava ime i stavlja ga u label
//                usernameLabel.setText(getUsername(userID));
//                //ostalo ucitava tenkove
//                loadedTanksId.clear();
//                resetCounter();
//                loadeHomeArticle(tankName1, tankClass1, tankPrice1, tankImage1, tankID1, sold);
//                loadeHomeArticle(tankName2, tankClass2, tankPrice2, tankImage2, tankID2, sold);
//                loadeHomeArticle(tankName3, tankClass3, tankPrice3, tankImage3, tankID3, sold);
//                loadeHomeArticle(tankName4, tankClass4, tankPrice4, tankImage4, tankID4, sold);
//                loadeHomeArticle(tankName5, tankClass5, tankPrice5, tankImage5, tankID5, sold);
//                loadeHomeArticle(tankName6, tankClass6, tankPrice6, tankImage6, tankID6, sold);
//                loadeHomeArticle(tankName7, tankClass7, tankPrice7, tankImage7, tankID7, sold);
//                loadeHomeArticle(tankName8, tankClass8, tankPrice8, tankImage8, tankID8, sold);
//                loadeHomeArticle(tankName9, tankClass9, tankPrice9, tankImage9, tankID9, sold);
//            } else noMoreLoad.setText("No more tanks to load");
//
//    }
//
//    public void loadNextKatalog() throws SQLException, IOException {
//        if (!PreviusLoad) {
//            PreviusLoad = true;
//            noMoreLoad.setText("");
//        }
//        if (MoreLoad) {
//            PreviusLoad=true;
//            badHomeLoader(Sold);
//        } else noMoreLoad.setText("No more tanks to load");
//    }
//
//    public void loadPreviusKatalog(ActionEvent actionEvent) throws SQLException, IOException {
//        if (!MoreLoad) {
//            MoreLoad = true;
//            noMoreLoad.setText("");
//        }
//        if(!PreviusLoad)
//            noMoreLoad.setText("No previous tanks to load");
//        Previus9Tank();
//        badHomeLoader(Sold);
//    }
//    public static void NoPreviusLoad(){
//        PreviusLoad=false;
//    }
////        public void openProfile(ActionEvent actionEvent) {
////            ProfileScreen();
////        }
//    //}









    //public class ArticleController {

//    @FXML
//    public Text articleName, articleClass, articlePrice, articleDiscription,purchaseErrorSucsses,articleAmount;
//    @FXML
//    public ImageView articleImage;
//    @FXML
//    public TextField purchaseAmount;
//
////    public void ArticleLoader() throws SQLException, IOException {
////        int ID = getarticleID();
////        articleName.setText(getTankName(ID));
////        articleClass.setText(getTankClass(ID));
////        articlePrice.setText(String.valueOf(getTankPrice(ID)));
////        articleImage.setImage(getTankImage(ID));
////        articleAmount.setText(getTankAmount(ID) +" left in stock");
////    }
//
//
//    public void badArticleLoader(MouseEvent mouseEvent) throws SQLException, IOException {
//        int ID = getarticleID();
//        articleName.setText(getTankName(ID));
//        articleClass.setText(getTankClass(ID));
//        articlePrice.setText(String.valueOf(getTankPrice(ID)));
//        articleImage.setImage(getTankImage(ID));
//        articleDiscription.setText(getTankDiscription(ID));
//        setArticleAmount(ID);
//    }
//
//    public void ChangeColor(MouseEvent mouseEvent) {
//        Button btn = (Button) mouseEvent.getSource();
//        btn.setTextFill(RED);
//
//    }
//
//    public void RevertColor(MouseEvent mouseEvent) {
//        Button btn = (Button) mouseEvent.getSource();
//        btn.setTextFill(Color.WHITE);
//    }
//
//    public void openHome(ActionEvent actionEvent) throws IOException, SQLException {
//        resetMoreLoad();
//        resetTankID();
//        HomeScreen(true);
//    }
//
//
//    public void articlePurchase(ActionEvent actionEvent) throws SQLException {
//        try {
//            int amount= getAmount();
//            if(amount>getTankAmount(getarticleID())){
//                purchaseErrorSucsses.setFill(RED);
//                purchaseErrorSucsses.setText("amount greater than stock");
//
//            }else if(amount!=0) {
//                purchaseArticle(getarticleID(), amount, userID);
//                purchaseErrorSucsses.setFill(GREEN);
//                purchaseErrorSucsses.setText("purchase successful");
//                setArticleAmount(getarticleID());
//            }else {
//                purchaseErrorSucsses.setFill(RED);
//                purchaseErrorSucsses.setText("incorrect amount input");
//
//            }
//        }catch (Exception e){
//            purchaseErrorSucsses.setFill(RED);
//            purchaseErrorSucsses.setText("purchase failed");
//            System.out.println(e);
//            throw e;
//
//        }
//    }
//
//    public void setArticleAmount(int id) throws SQLException {
//        if(getTankAmount(getarticleID())!=0) {
//            articleAmount.setText(getTankAmount(getarticleID()) + " left in stock");
//        }else{
//            articleAmount.setFill(RED);
//            articleAmount.setText("out of stock");
//        }
//    }
//
//    public int getAmount(){
//        String s=purchaseAmount.getText();
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)<'0' || s.charAt(i)>'9' ){
//                //throwError
//                return 0;
//            }
//
//        }
//        return Integer.parseInt(s);
//    }
//
//
//
////    public void openProfile(ActionEvent actionEvent) {
////        ProfileScreen();
////    }
    //}






















    // public class LoginController {
//    @FXML
//    private Text LoginError, RegisterError;
//    @FXML
//    private TextField EmailField, PassField, EmailReg, PassReg, UsernameReg;
//
//
//    @FXML
//
//
//    public void onLoginButtonClick() throws IOException, SQLException {
//        String Email = EmailField.getText();
//        String Pass = PassField.getText();
//        int ID;
//        String PassProv = GetPass(Email);
//
//        if (PassProv.equals(Pass)) {
//
//            HomeScreen(true);
//        } else {
//            LoginError.setText("Login not successful");
//        }
//    }
//
//    public void onSignUpButtonClick(ActionEvent actionEvent) throws IOException {
//        RegisterScreen();
//    }
//
//
//    public void onRegisterButtonClick() throws IOException, SQLException {
//        String Email = EmailReg.getText();
//        String Pass = PassReg.getText();
//        String Username = UsernameReg.getText();
//
//
//        if (CkeckAcc(Email)) {
//            RegisterError.setText("email already registerd");
//        } else {
//            try {
//                AddAcc(Email, Pass, Username);
//                LoginScreen();
//            } catch (Exception a) {
//                System.out.println(a);
//            }
//        }
//
//    }
//
//
//    public void BackButton(ActionEvent actionEvent) throws IOException {
//        LoginScreen();
//    }

//}













    //public class ProfileController {

//        @FXML
//      //  public Label usernameLabel;
////        public void openHome(ActionEvent actionEvent) throws IOException, SQLException {
////            HomeScreen();
////            resetTankID();
////        }
//
////        public void ChangeColor(MouseEvent mouseEvent){
////            Button btn = (Button) mouseEvent.getSource();
////            btn.setTextFill(Color.RED);
////
////        }
//
////        public void RevertColor(MouseEvent mouseEvent) {
////            Button btn = (Button) mouseEvent.getSource();
////            btn.setTextFill(Color.WHITE);
////        }
//
//
////        public void setstuf(MouseEvent mouseEvent)  throws SQLException {
////            usernameLabel.setText(getUsername(userID));
////        }
//
//    public ListView<String> reciteList;
//
//    public TextField newEmail,newUsername,newPassword;
//    public Label ChangeErrorSuccses;
//
//    public void changeEmail(ActionEvent actionEvent) throws SQLException {
//        String s=newEmail.getText();
//        if(s.isEmpty()){
//            ChangeErrorSuccses.setTextFill(RED);
//            ChangeErrorSuccses.setText("Field cant be empty");
//        }else  if(CkeckAcc(s)){
//            ChangeErrorSuccses.setTextFill(RED);
//            ChangeErrorSuccses.setText("Email already registerd");
//        }else{
//            ChangeEmail(s,ID);
//            ChangeErrorSuccses.setTextFill(GREEN);
//            ChangeErrorSuccses.setText("Email successfully changed");
//            newEmail.clear();
//        }
//
//    }
//
//    public void changeUsername(ActionEvent actionEvent) throws SQLException {
//        String s=newUsername.getText();
//        if(s.isEmpty()) {
//            ChangeErrorSuccses.setTextFill(RED);
//            ChangeErrorSuccses.setText("Field cant be empty");
//        }
//        else {
//            ChangeUsername(s, ID);
//            ChangeErrorSuccses.setTextFill(GREEN);
//            ChangeErrorSuccses.setText("Username successfully changed");
//            usernameLabel.setText(getUsername(userID));
//            newUsername.clear();
//        }
//    }
//
//    public void changePassword(ActionEvent actionEvent) throws SQLException {
//        String s=newPassword.getText();
//        if(s.isEmpty()) {
//            ChangeErrorSuccses.setTextFill(RED);
//            ChangeErrorSuccses.setText("Field cant be empty");
//        }
//        else {
//            ChangePass(s, ID);
//            ChangeErrorSuccses.setTextFill(GREEN);
//            ChangeErrorSuccses.setText("Password successfully changed");
//            newPassword.clear();
//        }
//    }
//    // }
//
//    public void loadRecite() throws SQLException {
//        ResultSet rec=getRecite(userID);
//        while(rec.next()){
//                String s = "Recite ID: " + rec.getString(1) + ".   User ID: " + rec.getString(2) + ".   Thank purchased: " + rec.getString(6) + ".  Amount purchased: " + rec.getString(4) + ".  Total price:" + rec.getString(5) + ".";
//                reciteList.getItems().add(s);
//
//        }
//    }
//
//
//
//
//
//
//    //sold controller
//
//
//
//    public void openSold() throws SQLException {
//            resetMoreLoad();
//            resetTankID();
//            HomeScreen(false);
//
//    }
//

//}
