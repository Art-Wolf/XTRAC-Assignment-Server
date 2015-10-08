package ie.johndoyle.dao;

import ie.johndoyle.entity.Item;

import java.util.List;

/**
 * Created by johnc on 10/6/2015.
 */
public interface ItemDAO {

    void add(Item item);

    List<Item> getAll(String account);
}
