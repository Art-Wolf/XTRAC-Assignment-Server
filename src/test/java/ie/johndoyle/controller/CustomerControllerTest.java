package ie.johndoyle.controller;

import ie.johndoyle.Config;
import ie.johndoyle.dao.CustomerDAO;
import ie.johndoyle.entity.Customer;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

/**
 * Created by johnc on 10/7/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)
public class CustomerControllerTest extends TestCase {

    @Autowired
    private CustomerDAO customerDAO;

    private CustomerController customerController;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        customerController = new CustomerController(customerDAO) ;
    }

    @Test
    public void testCustomerController() {
        Customer testCustomer = new Customer(-1, "JUnit", "Test", "Address", "Postal", "State", "Y000");

        customerDAO.add(testCustomer);

        Object [] returnArray = customerController.getCustomer(testCustomer.getAccountNo());

        Assert.assertEquals (returnArray.length, 1);

        Customer returnedCustomer = (Customer) returnArray[0];

        Assert.assertEquals(returnedCustomer.getAccountNo(), testCustomer.getAccountNo());
    }
}