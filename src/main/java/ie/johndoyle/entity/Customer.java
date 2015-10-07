package ie.johndoyle.entity;

public class Customer {

    private final long id;
    private final String fname, lname, address, postal, state, accountNo;

    public Customer(long id, String fname, String lname, String address, String postal, String state, String accountNo) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.postal = postal;
        this.state = state;
        this.accountNo = accountNo;
    }

    public long getId() {
        return id;
    }

    public String getFname() { return fname; }

    public String getLname() { return lname; }

    public String getAddress() { return address; }

    public String getPostal() { return postal; }

    public String getState() { return state; }

    public String getAccountNo() { return accountNo; }
}
