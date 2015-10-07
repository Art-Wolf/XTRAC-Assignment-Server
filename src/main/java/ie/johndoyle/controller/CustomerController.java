package ie.johndoyle.controller;

import java.util.concurrent.atomic.AtomicLong;

import ie.johndoyle.dao.CustomerDAO;
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

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/customer")
    public Object[] getCustomer(@RequestParam(value="fname", defaultValue="John") String fname,
                               @RequestParam(value="lname", defaultValue="Doe") String lname,
                               @RequestParam(value="address", defaultValue="245 Summer St") String address,
                               @RequestParam(value="postal", defaultValue="02110") String postal,
                               @RequestParam(value="state", defaultValue="MA") String state
                               ) {
        Object [] customerList = customerDAO.getAll().toArray();
        return customerList;
    }
}
