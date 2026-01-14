public class MainStore {
    public static void main(String[] args) {
        SalesStore store = new SalesStore();
        store.addProduct("Яблоки", 100, 5);
        store.addProduct("Бананы", 80, 9);
        store.addProduct("Груши", 1, 8);
        store.addProduct("Груши", 3, 8);
        store.addProduct("Груши", 3, 9);
        System.out.println(store.setProducts());
        System.out.println(store.sumSales());
        System.out.println(store.popularProduct());
    }
}
