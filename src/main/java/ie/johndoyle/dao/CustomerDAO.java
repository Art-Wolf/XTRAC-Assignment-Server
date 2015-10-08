package ie.johndoyle.dao;

import ie.johndoyle.entity.Customer;

import java.util.List;

/**
 * Created by johnc on 10/6/2015.
 */
public interface CustomerDAO {

    void add(Customer customer);

    List<Customer> getAll();
}
