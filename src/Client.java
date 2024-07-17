public class Client {
    public static void main(String[] args) {
        Order order = new Order(1);

        PriceObserver priceObserver = new PriceObserver();
        QuantityObserver quantityObserver = new QuantityObserver();

        order.attach(priceObserver);
        order.attach(quantityObserver);

        Item item1 = new Item(50, 2);
        Item item2 = new Item(100, 3);
        Item item3 = new Item(70, 1);

        order.addItem(item1);
        System.out.println(order);

        order.addItem(item2);
        System.out.println(order);

        order.addItem(item3);
        System.out.println(order);

        order.removeItem(item1);
        System.out.println(order);

        order.removeItem(item2);
        System.out.println(order);
    }
}
