package ie.johndoyle.impl;

import ie.johndoyle.dao.ItemDAO;
import ie.johndoyle.entity.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/**
 * Created by johnc on 10/6/2015.
 */
public class ItemImpl implements ItemDAO {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private List<Item> itemList = new ArrayList<Item>();
    private final AtomicLong counter = new AtomicLong();

    private XMLParserImpl xmlParser = new XMLParserImpl();

    public ItemImpl() {
        super();

        Document dom = xmlParser.parseXMLFile();
        List<Item> documentList = xmlParser.parseItemDocument(dom);

        Iterator<Item> itemIterator = documentList.iterator();
        while(itemIterator.hasNext()){
            add(itemIterator.next());
        }
    }

    public void add(Item item) {
        itemList.add(item);
    }

    public List<Item> getAll(String account) {

        List<Item> returnList = new ArrayList<Item>();

        for (Item item : itemList) {
            log.debug("Account: " + item.getAccount());
            if (item.getAccount().compareTo(account) == 0) {
                log.debug("MATCH!");
                returnList.add(item);
            }
        }
        return returnList;
    }
}
