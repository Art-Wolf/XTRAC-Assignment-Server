package ie.johndoyle.controller;

import ie.johndoyle.Config;
import ie.johndoyle.dao.ItemDetailDAO;
import ie.johndoyle.entity.ItemDetail;
import ie.johndoyle.impl.ItemDetailImplTest;
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
public class ItemDetailControllerTest extends TestCase {


    private ItemDetailDAO itemDetailDAO;

    private ItemDetailController itemDetailController;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        itemDetailDAO = new ItemDetailImplTest();
        itemDetailController = new ItemDetailController(itemDetailDAO);
    }

    @Test
    public void testGetItemDetail() throws Exception {
        String testSymbol = "TWTR";

        Object [] returnArray = itemDetailController.getItemDetail(testSymbol);

        Assert.assertEquals(returnArray.length, 1);

        ItemDetail returnedItem = (ItemDetail) returnArray[0];

        Assert.assertEquals(returnedItem.getSymbol(), testSymbol);
    }
}