package ie.johndoyle.dao;

import ie.johndoyle.entity.ItemDetail;

import java.util.List;

/**
 * Created by johnc on 10/6/2015.
 */
public interface ItemDetailDAO {

    ItemDetail get(String symbol);

}
