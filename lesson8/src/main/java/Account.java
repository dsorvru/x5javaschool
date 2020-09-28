public class Account {

    private int id;
    private String holder;
    private int amount;

    public Account(int id, String holder) {
        this(id, holder, 0);
    }

    public Account(int id, String holder, int amount) {
        this.id = id;
        this.holder = holder;
        this.amount = amount;
    }

    public Account(Account that) {
        this.id = that.id;
        this.amount = that.amount;
        this.holder = that.holder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int decreaseAmount(int amount) {
        this.amount -= amount;
        return this.amount;
    }

    public int increaseAmount(int amount) {
        this.amount += amount;
        return this.amount;
    }
}
