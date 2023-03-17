package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Recite;

import java.util.List;

/**
 * Dao interface for QuoteHistory domain bean
 *
 * @author Dino Keco
 */
public interface ReciteDao extends Dao<Recite> {

    Recite getById(int id) throws Exception;
    int getNextReciteId() throws Exception;
    List<Recite> getUserRecite(int userID)throws Exception;

}