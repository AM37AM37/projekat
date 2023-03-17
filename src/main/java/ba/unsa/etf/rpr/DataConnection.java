//package ba.unsa.etf.rpr;
//
//import com.mysql.cj.jdbc.Blob;
//import javafx.embed.swing.SwingFXUtils;
//import javafx.scene.image.Image;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.*;
//import java.util.Properties;
//
////import static ba.unsa.etf.rpr.MainControler.NoPreviusLoad;
//
//
//public class DataConnection {
//
//
//    public static Connection connection=null;
//    public static Statement rs;
//    public static int ID;

  /*  //OLD connect
    public static void Connect() throws SQLException, ClassNotFoundException {
        String username="projekt";
        String password="!154TrE?Cf154!";
        String URL="jdbc:mysql://localhost/data";
        //Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection(URL,username,password);
        rs  = (Statement) connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet user = connection.createStatement().executeQuery("select * from user_info");
        System.out.println("user table:");
        ResultSetOut(user);
        ResultSet tank = connection.createStatement().executeQuery("select * from tenk_katalog");
        tankLoad=connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        ).executeQuery("select * from tenk_katalog");
        System.out.println("tank table:");
        ResultSetOut(tank);
    }


*/
//
//    public static void Connect() throws SQLException, ClassNotFoundException, IOException {
//
//        //Class.forName("com.mysql.cj.jdbc.Driver");
//
//
//
//
//
//        Properties p = new Properties();
//        p.load(ClassLoader.getSystemResource("ba/unsa/etf/rpr/dp.properties").openStream());
//        String url = p.getProperty("db.connection_string");
//        String username = p.getProperty("db.username");
//        String password = p.getProperty("db.password");
//        connection = DriverManager.getConnection(url, username, password);
//
//
//
//        rs  = (Statement) connection.createStatement(
//                ResultSet.TYPE_SCROLL_INSENSITIVE,
//                ResultSet.CONCUR_UPDATABLE);
//        ResultSet user = connection.createStatement().executeQuery("select * from user_info");
//        System.out.println("user table:");
//        ResultSetOut(user);
//        ResultSet tank = connection.createStatement().executeQuery("select * from tenk_katalog");
//        tankLoad=connection.createStatement(
//                ResultSet.TYPE_SCROLL_INSENSITIVE,
//                ResultSet.CONCUR_UPDATABLE
//        ).executeQuery("select * from tenk_katalog");
//        System.out.println("tank table:");
//        ResultSetOut(tank);
//    }
//
//    public static void ResultSetOut(ResultSet user) throws SQLException {
//
//        while (user.next())
//            System.out.println(user.getString(1)+" "+user.getString(2)+" "+user.getString(3)+" "+user.getString(4));
//
//    }

//    public static String GetPass(String email) throws SQLException {
//        ResultSet res = connection.createStatement().executeQuery("select * from user_info");
//        while (res.next()){
//            if(email.equals(res.getString(3))) {
//                ID = res.getInt(1);
//                return res.getString(4);
//            }
//        }
//        return "0";
//    }
//
//    public static int getID(){
//        return ID;
//    }

//    public static Boolean CkeckAcc(String email) throws SQLException {
//        ResultSet res = connection.createStatement().executeQuery("select * from user_info");
//        while (res.next()){
//            if(email.equals(res.getString(3)))
//                return true;
//        }
//        return false;
//    }
//
//    public static void AddAcc(String email,String pass,String username) throws SQLException {
//        //ResultSet res = rs.executeQuery("select * from user_info");
//
//        String sql="INSERT INTO `data`.`user_info` (`user_ID`, `username`, `email`, `password`) VALUES ('"+GetNextID()+"', '"+username+"', '"+email+"', '"+pass+"');";
//        rs.executeUpdate(sql);
//    }
//
//    public static int GetNextID() throws SQLException {
//        ResultSet res = connection.createStatement().executeQuery("select * from user_info");
//        int i=0;
//        while (res.next()){
//            if(i==res.getInt(1))
//                i++;
//            else return i;
//        }
//        return i;
//    }
//
//    //mozes pogodit
//    public static String getUsername(int ID) throws SQLException {
//        ResultSet res = connection.createStatement().executeQuery("select * from user_info");
//        while (res.next()){
//            if(ID==res.getInt(1))
//                return res.getString(2);
//        }
//        return null;
//    }
//
//    public static String getEmail(int ID) throws SQLException {
//        ResultSet res = connection.createStatement().executeQuery("select * from user_info");
//        while (res.next()){
//            if(ID==res.getInt(1))
//                return res.getString(3);
//        }
//        return null;
//    }
//
//    public static String getPass(int ID) throws SQLException {
//        ResultSet res = connection.createStatement().executeQuery("select * from user_info");
//        while (res.next()){
//            if(ID==res.getInt(1))
//                return res.getString(4);
//        }
//        return null;
//    }
//
//    public static void ChangeEmail(String s,int ID) throws SQLException {
//        String sql="UPDATE `data`.`user_info` SET `email` = '"+s+"' WHERE (`user_ID` = '"+ID+"');";
//        rs.executeUpdate(sql);
//
//    }
//
//    public static void ChangePass(String s,int ID) throws SQLException {
//        String sql="UPDATE `data`.`user_info` SET `password` = '"+s+"' WHERE (`user_ID` = '"+ID+"');";
//        rs.executeUpdate(sql);
//
//    }
//
//    public static void ChangeUsername(String s,int ID) throws SQLException {
//        String sql="UPDATE `data`.`user_info` SET `username` = '"+s+"' WHERE (`user_ID` = '"+ID+"');";
//        rs.executeUpdate(sql);
//
//    }






    //Tank data start




//
//    public static int loadedTankCounter=0;
//    public static ResultSet tankLoad;
//    public static boolean nextTankID() throws SQLException {
//        if(tankLoad.next()) {
//            loadedTankCounter++;
//            System.out.println("next"+ loadedTankCounter);
//            return true;
//        }
//        else{
//            System.out.println("here");
//            tankLoad.previous();
//            return false;
//        }
//    }
//
//    public static void resetCounter(){loadedTankCounter=0;}
//
//    public static void resetTankID() throws SQLException {
//        tankLoad=connection.createStatement(
//                ResultSet.TYPE_SCROLL_INSENSITIVE,
//                ResultSet.CONCUR_UPDATABLE).executeQuery("select * from tenk_katalog");
//    }
//
//    public static Integer getTankID() throws SQLException {
//        return tankLoad.getInt(1);
//    }
//    public static String getTankName() throws SQLException {
//        return tankLoad.getString(2);
//    }
//
//    public static String getTankClass() throws SQLException {
//        return tankLoad.getString(3);
//    }
//
//    public static int getTankPrice() throws SQLException {
//        return tankLoad.getInt(4);
//    }
//    public static int getTankAmount() throws SQLException {
//        return tankLoad.getInt(7);
//    }
//
//    public static Image getTankImage() throws SQLException, IOException {
//    try {
//
//        Blob blob= (Blob) tankLoad.getBlob(6);
//        return SwingFXUtils.toFXImage(ImageIO.read(blob.getBinaryStream()),null);
//    }catch (Exception e){
//        throw e;
//    }
//    }
//
//    public static Integer getTankID(int ID) throws SQLException {
//        return getTankByID(ID).getInt(1);
//    }
//    public static String getTankName(int ID) throws SQLException {
//        return  getTankByID(ID).getString(2);
//    }
//
//    public static String getTankClass(int ID) throws SQLException {
//        return  getTankByID(ID).getString(3);
//    }
//
//    public static int getTankPrice(int ID) throws SQLException {
//        return  getTankByID(ID).getInt(4);
//    }
//
//    public static int getTankAmount(int ID) throws SQLException{
//        return  getTankByID(ID).getInt(7);
//    }
//
//    public static Image getTankImage(int ID) throws SQLException, IOException {
//        Blob blob= (Blob)  getTankByID(ID).getBlob(6);
//        InputStream in = blob.getBinaryStream();
//        BufferedImage imagen = ImageIO.read(in);
//        Image imagenMonstruo = SwingFXUtils.toFXImage(imagen,null);
//        return imagenMonstruo;
//    }
//
//    public static String getTankDiscription(int ID) throws SQLException {
//        return getTankByID(ID).getString(5);
//    }
//    public static ResultSet getTankByID(int ID) throws SQLException {
//        ResultSet tank = connection.createStatement().executeQuery("select * from tenk_katalog");
//        while(tank.next()){
//            if(tank.getInt(1)==ID)
//                return tank;
//        }
//        return null;
//    }
//
//    public static void Previus9Tank() throws SQLException {
//        for (int i=0;i<10+loadedTankCounter;i++){
//            if(tankLoad.previous()) {
//                System.out.println(i);
//            }else {
//                System.out.println("here");
//               // NoPreviusLoad();
//            }
//        }resetCounter();
//
//    }
//
//    public static void  purchaseArticle(int id,int amount,int user) throws SQLException {
//        String sql="INSERT INTO `data`.`recites` (`recite_id`, `user_id`, `tank_id`, `amount`, `total`, `tank_name`) VALUES ('"+getNextRecietID()+"', '"+user+"', '"+id+"', '"+amount+"', '"+getTankPrice(id)*amount+"', '"+getTankName(id)+"');";
//        rs.executeUpdate(sql);
//        sql="UPDATE `data`.`tenk_katalog` SET `amount` = '"+(getTankAmount(id)-amount)+"' WHERE (`tank_id` = '"+id+"');";
//        rs.executeUpdate(sql);
//    }
//
//    public static int getNextRecietID() throws SQLException {
//        ResultSet res = connection.createStatement().executeQuery("select * from recites");
//        int i=1;
//        while (res.next()){
//            if(i==res.getInt(1))
//                i++;
//            else return i;
//        }
//        return i;
//    }






    //recite data



//    public static ResultSet getRecite(int id) throws SQLException {
//        return connection.createStatement().executeQuery("select * from recites where user_id = "+id);
//    }

//}
