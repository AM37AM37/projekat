package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Katalog;
import ba.unsa.etf.rpr.domain.User;

import java.util.List;

/**
 * Dao interface for Category domain bean
 *
 * @author Dino Keco
 */
public interface UserDao extends Dao<User> {

    User getById(int id) throws Exception;
    User searchByEmail(String s)throws  Exception;
}
