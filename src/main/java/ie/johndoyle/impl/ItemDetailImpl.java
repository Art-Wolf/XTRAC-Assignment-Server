package ie.johndoyle.impl;

import ie.johndoyle.dao.ItemDAO;
import ie.johndoyle.dao.ItemDetailDAO;
import ie.johndoyle.entity.Item;
import ie.johndoyle.entity.ItemDetail;
import org.springframework.beans.factory.annotation.Autowired;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by johnc on 10/6/2015.
 */
public class ItemDetailImpl implements ItemDetailDAO {


    private final AtomicLong counter = new AtomicLong();

    public ItemDetailImpl() {
        super();
    }

    public ItemDetail get(String symbol) {

        ItemDetail itemDetail;
        try {
            Stock stock = YahooFinance.get(symbol);

            itemDetail = new ItemDetail(
                    counter.incrementAndGet(),
                    stock.getSymbol(),
                    stock.getName(),
                    stock.getQuote().getChange().doubleValue(),
                    stock.getQuote().getPrice().doubleValue());
        } catch (IOException exception) {
            itemDetail = new ItemDetail();
            exception.printStackTrace();
        }

        return itemDetail;
    }

}
