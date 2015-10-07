package ie.johndoyle.entity;

/**
 * Created by johnc on 10/5/2015.
 */
public class ItemDetail {

    private final long id;
    private final String symbol;
    private final String name;
    private final double change;
    private final double price;

    public ItemDetail(){
        id = 0;
        symbol = "";
        name = "";
        change = 0;
        price = 0;
    }

    public ItemDetail(long id, String symbol, String name, double change, double price) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.change = change;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getSymbol() { return symbol; }

    public String getName() { return name; }

    public double getChange() { return change; }

    public double getPrice() { return price; }

}
