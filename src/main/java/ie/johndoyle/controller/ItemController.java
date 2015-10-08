package ie.johndoyle.controller;

import ie.johndoyle.dao.CustomerDAO;
import ie.johndoyle.dao.ItemDAO;
import ie.johndoyle.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RestController
public class ItemController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private ItemDAO itemDAO;

    public ItemController() {}

    public ItemController(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @RequestMapping("/item")
    public Object[] getItem(@RequestParam(value="account", defaultValue="") String account
    ) {
        return itemDAO.getAll(account).toArray();
    }
}
