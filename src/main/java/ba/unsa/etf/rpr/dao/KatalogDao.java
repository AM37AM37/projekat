package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Katalog;



public interface KatalogDao extends Dao<Katalog>{


    Katalog getById(int id) throws Exception;
    int getNextTankId() throws Exception;
    void updateTankId(int old,int neww) throws Exception;








//    /**
//     * Returns all quotes that contains given text.
//     *
//     * @param text search string for quotes
//     * @return list of quotes
//     */
//    List<Quote> searchByText(String text) throws QuoteException;
//
//    /**
//     * Returns all quotes that contains given text.
//     *
//     * @param category search string for quotes
//     * @return list of quotes
//     */
//    List<Quote> searchByCategory(Category category) throws QuoteException;
//
//    /**
//     * Return random quote from database
//     *
//     * @return random quote
//     * @throws QuoteException
//     */
//    Quote randomQuote() throws QuoteException;;

}
