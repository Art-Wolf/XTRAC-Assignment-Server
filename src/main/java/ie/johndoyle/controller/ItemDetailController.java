package ie.johndoyle.controller;

import ie.johndoyle.dao.ItemDAO;
import ie.johndoyle.dao.ItemDetailDAO;
import ie.johndoyle.entity.ItemDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RestController
public class ItemDetailController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private ItemDetailDAO itemDetailDAO;

    public ItemDetailController() {}

    public ItemDetailController(ItemDetailDAO itemDetailDAO) {
        this.itemDetailDAO = itemDetailDAO;
    }

    @RequestMapping("/itemdetail")
    public ItemDetail[] getItemDetail(@RequestParam(value="symbol", defaultValue="") String symbol
    ) {
        ItemDetail [] itemDetails = new ItemDetail[1];

        itemDetails[0] = itemDetailDAO.get(symbol);

        return itemDetails;
    }
}
