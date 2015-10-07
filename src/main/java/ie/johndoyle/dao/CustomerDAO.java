package ie.johndoyle.dao;

import ie.johndoyle.entity.Customer;

import java.util.List;

/**
 * Created by johnc on 10/6/2015.
 */
public interface CustomerDAO {

    public void add(Customer customer);

    public List<Customer> getAll();
}
