package ie.johndoyle.entity;

/**
 * Created by johnc on 10/5/2015.
 */
public class Item {

    private final long id;
    private final String symbol;
    private final String account;
    private final long quantity;

    public Item(long id, String account, String symbol, long quantity) {
        this.id = id;
        this.account = account;
        this.symbol = symbol;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public String getAccount() { return account; }

    public String getSymbol() { return symbol; }

    public long getQuantity() { return quantity; }
}
