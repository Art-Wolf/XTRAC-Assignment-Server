package ie.johndoyle.dao;

import ie.johndoyle.entity.Item;

import java.util.List;

/**
 * Created by johnc on 10/6/2015.
 */
public interface ItemDAO {

    public void add(Item item);

    public List<Item> getAll(String account);
}
