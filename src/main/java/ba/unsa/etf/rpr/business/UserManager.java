package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;

import java.util.List;

public class UserManager {









    public static String GetPassByEmail(String email) throws Exception {
        User u=DaoFactory.userDao().searchByEmail(email);

        return u.getPassword();
    }

    public static User GetUserByEmail(String email) throws Exception {

        return DaoFactory.userDao().searchByEmail(email);
    }




    public static boolean CkeckEmail(String email) throws Exception {
        try{
            DaoFactory.userDao().searchByEmail(email);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }

    }




    public static User AddAcc(User newuser) throws Exception {

        try{
            return DaoFactory.userDao().add(newuser);
        }catch (Exception e){
            throw e;
        }
    }


        public static List<User> getAllUsers() throws Exception{
            System.out.println(DaoFactory.userDao().getAll());
        return DaoFactory.userDao().getAll();
    }


}
