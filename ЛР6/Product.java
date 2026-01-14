public class Product implements Comparable<Product> {
    private String name;
    private double price;
    private int count;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void sell(double price, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть положительной");
        }
        this.price = (this.price * this.count + price * count) / (this.count + count);
        this.count += count;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Product other) {
        return this.name.compareTo(other.name);
    }
}