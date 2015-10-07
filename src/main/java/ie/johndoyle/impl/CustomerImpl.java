package ie.johndoyle.impl;

import ie.johndoyle.dao.CustomerDAO;
import ie.johndoyle.dao.ItemDAO;
import ie.johndoyle.dao.ItemDetailDAO;
import ie.johndoyle.entity.Customer;
import ie.johndoyle.entity.Item;
import ie.johndoyle.entity.ItemDetail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Created by johnc on 10/6/2015.
 */
public class CustomerImpl implements CustomerDAO {

    @Autowired
    private ItemDAO itemDAO;

    private XMLParserImpl xmlParser = new XMLParserImpl();

    private Document dom;
    private List<Customer> customerList = new ArrayList<Customer>();
    private final AtomicLong counter = new AtomicLong();

    public CustomerImpl() {
        super();

        Document dom = xmlParser.parseXMLFile();
        List<Customer> documentList = xmlParser.parseCustomerDocument(dom);

        Iterator<Customer> customerIterator = documentList.iterator();
        while(customerIterator.hasNext()){
            add(customerIterator.next());
        }
    }



    public void add(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> getAll() {
        return customerList;
    }
}
