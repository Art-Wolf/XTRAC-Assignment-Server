package ie.johndoyle.impl;

import ie.johndoyle.entity.Customer;
import ie.johndoyle.entity.Item;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by johnc on 10/7/2015.
 */
public class XMLParserImpl {

    private final AtomicLong counter = new AtomicLong();

    public Document parseXMLFile() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document dom = null;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("portfolios.xml").getFile());
            dom = builder.parse(file);

        } catch(ParserConfigurationException error) {
            error.printStackTrace();
        }catch(org.xml.sax.SAXException error) {
            error.printStackTrace();
        }catch(IOException error) {
            error.printStackTrace();
        }

        return dom;
    }

    public List<Customer> parseCustomerDocument(Document dom) {
        List<Customer> customerList = new ArrayList<Customer>();

        Element element = dom.getDocumentElement();
        NodeList customerNode = element.getElementsByTagName("customer");
        if(customerNode != null && customerNode.getLength() > 0) {
            for(int i = 0 ; i < customerNode.getLength();i++) {
                Element customerElement = (Element)customerNode.item(i);
                customerList.add(parseCustomer(customerElement));
            }
        }

        return  customerList;
    }

    public List<Item> parseItemDocument(Document dom) {
        List<Item> itemList = new ArrayList<Item>();

        Element element = dom.getDocumentElement();
        NodeList customerNode = element.getElementsByTagName("customer");
        if(customerNode != null && customerNode.getLength() > 0) {
            for(int i = 0 ; i < customerNode.getLength();i++) {
                Element customerElement = (Element)customerNode.item(i);
                itemList.addAll(parsePositions(customerElement));
            }
        }

        return itemList;
    }

    private Customer parseCustomer(Element element) {
        String account = getValue(element, "account");
        String fname = getValue(element, "fname");
        String lname = getValue(element, "lname");
        String address = getValue(element, "address");
        String postal = getValue(element, "postal");
        String state = getValue(element, "state");

        return new Customer(counter.incrementAndGet(), fname, lname, address, postal, state, account);
    }

    private List<Item> parsePositions(Element element) {
        List<Item> itemList = new ArrayList<Item>();

        String account = getValue(element, "account");

        //NodeList portfolio = element.getElementsByTagName("portfolio");
        //if(portfolio != null && portfolio.getLength() > 0) {
        //    for(int i = 0 ; i < portfolio.getLength();i++) {
        //        Element position = (Element) portfolio.item(i);
                NodeList positionList = element.getElementsByTagName("position");
                if(positionList != null && positionList.getLength() > 0) {
                    for(int u = 0 ; u < positionList.getLength();u++) {
                        Element positionElement = (Element) positionList.item(u);
                        String symbol = getValue(positionElement, "symbol");
                        long quantity = Long.parseLong(getValue(positionElement, "quantity"));
                        Item item = new Item(counter.incrementAndGet(),
                                account,
                                symbol,
                                quantity
                        );
                        itemList.add(item);
                    }}
            //}
        //}

        return itemList;
    }

    private String getValue(Element element, String node) {
        NodeList value = element.getElementsByTagName(node);
        String returnValue = "";
        if(value != null && value.getLength() > 0) {
            returnValue = value.item(0).getFirstChild().getNodeValue();
        }

        return returnValue;

    }
}
