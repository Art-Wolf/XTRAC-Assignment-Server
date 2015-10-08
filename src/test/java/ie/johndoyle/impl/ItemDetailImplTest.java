package ie.johndoyle.impl;

import ie.johndoyle.dao.ItemDetailDAO;
import ie.johndoyle.entity.ItemDetail;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by johnc on 10/6/2015.
 */
public class ItemDetailImplTest implements ItemDetailDAO {


    private final AtomicLong counter = new AtomicLong();

    public ItemDetailImplTest() {
        super();
    }

    public ItemDetail get(String symbol) {

        return new ItemDetail(-1, symbol, "Unit Test", 10, 5);
    }

}
