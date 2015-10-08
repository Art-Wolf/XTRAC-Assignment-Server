package ie.johndoyle.controller;

import java.util.concurrent.atomic.AtomicLong;

import ie.johndoyle.dao.CustomerDAO;
import ie.johndoyle.entity.Item;
import ie.johndoyle.impl.CustomerImpl;
import ie.johndoyle.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RestController
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    public CustomerController() {}

    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    private final AtomicLong counter = new AtomicLong();



    @RequestMapping("/customer")
    public Object[] getCustomer(@RequestParam(value = "account", defaultValue = "") String account) {
        Object[] customerList = customerDAO.getAll().toArray();

        if (account.compareTo("") != 0) {
            Object[] individual = new Object[1];

            for (Object objCustomer : customerList) {
                Customer customer = (Customer) objCustomer;
                if (customer.getAccountNo().compareTo(account) == 0) {
                    individual[0] = (Object) customer;
                }
            }

            customerList = individual;
        }

        return customerList;
    }
}
