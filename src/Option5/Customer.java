package Option5;

public class Customer extends Person{
    
    private int Money;
    private int Products;
    private String Shop;
    
    public Customer()
    {
        
    }
    
    public Customer(String name, String city, char gender, int age, int cellphone,int money, int products, String shop)
    {
        super(name, city, gender, age, cellphone);
        this.Money = money;
        this.Products = products;
        this.Shop = shop;
    }

    /**
     * @return the Money
     */
    public int getMoney() {
        return Money;
    }

    /**
     * @param Money the Money to set
     */
    public void setMoney(int Money) {
        this.Money = Money;
    }

    /**
     * @return the Products
     */
    public int getProducts() {
        return Products;
    }

    /**
     * @param Products the Products to set
     */
    public void setProducts(int Products) {
        this.Products = Products;
    }

    /**
     * @return the Shop
     */
    public String getShop() {
        return Shop;
    }

    /**
     * @param Shop the Shop to set
     */
    public void setShop(String Shop) {
        this.Shop = Shop;
    }
    
}
