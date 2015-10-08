package ie.johndoyle.controller;

import ie.johndoyle.Config;
import ie.johndoyle.dao.ItemDAO;
import ie.johndoyle.entity.Item;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by johnc on 10/7/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)
public class ItemControllerTest extends TestCase {

    @Autowired
    private ItemDAO itemDAO;

    private ItemController itemController;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        itemController = new ItemController(itemDAO);
    }

    @Test
    public void testGetItem() throws Exception {

        Item testItem = new Item(-1, "Y00", "IBM", 10);

        itemDAO.add(testItem);

        Object [] returnArray = itemController.getItem(testItem.getAccount());

        Assert.assertEquals(returnArray.length, 1);

        Item returnedItem = (Item) returnArray[0];

        Assert.assertEquals(returnedItem.getSymbol(), returnedItem.getSymbol());
    }
}