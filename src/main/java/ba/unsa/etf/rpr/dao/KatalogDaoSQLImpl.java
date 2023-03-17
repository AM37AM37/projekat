package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Katalog;
import com.mysql.cj.jdbc.Blob;

import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL Implementation of DAO
 * @author Dino Keco
 */
public class KatalogDaoSQLImpl extends AbstractDao<Katalog> implements KatalogDao {

    public KatalogDaoSQLImpl() {
        super("tenk_katalog");
    }

    @Override
    public Katalog row2object(ResultSet rs) throws Exception{
        try {
            Katalog q = new Katalog();
            q.setId(rs.getInt("id"));
            q.setTankName(rs.getString("tank_name"));
            q.setTankClass(rs.getString("tank_class"));
            q.setPrice(rs.getInt("tank_price"));
            q.setDescription(rs.getString("tank_discription"));
            q.setTankImage((Blob) rs.getBlob("tenk_image"));
            q.setTankAmount(rs.getInt("amount"));
            return q;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * @param object - object to be mapped
     * @return map representation of object
     */
    @Override
    public Map<String, Object> object2row(Katalog object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("tank_name", object.getTankName());
        item.put("tank_class", object.getTankClass());
        item.put("tank_price", object.getPrice());
        item.put("tank_discription", object.getDescription());
        item.put("tenk_image", object.getTankImage());
        item.put("amount",object.getTankAmount());
        return item;
    }




//    public  Katalog getById(int id) throws Exception {
//        return executeQueryUnique("SELECT * FROM tenk_katalog WHERE id = ?", new Object[]{id});
//    }

    public int getNextTankId() throws Exception {
        Katalog k =executeQueryUnique("SELECT * FROM tenk_katalog where id = (SELECT coalesce(max(id)) AS ID FROM tenk_katalog LIMIT 0, 1000)",null);
        return  k.getId()+1;
    }

    /**
     * @param text search string for quotes
     * @return list of quotes
     * @author ahajro2
     */

//    @Override
//    public List<Katalog> searchByText(String text) throws KatalogException{
//        return executeQuery("SELECT * FROM quotes WHERE quote LIKE concat('%', ?, '%')", new Object[]{text});
//    }
//
//    /**
//     * @param category search string for quotes
//     * @return list of quotes
//     * @author ahajro2
//     */
//    @Override
//    public List<Katalog> searchByCategory(Category category) throws KatalogException{
//        return executeQuery("SELECT * FROM quotes WHERE category_id = ?", new Object[]{category.getId()});
//    }
//
//    /**
//     * @return random quote from DB
//     * @throws KatalogException in case of error working with db
//     */
//    @Override
//    public Katalog randomKatalog() throws KatalogException {
//        return executeQueryUnique("SELECT * FROM quotes ORDER BY RAND() LIMIT 1", null);
//    }
}
