import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderObserver> observers = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private double totalPrice;
    private int totalQuantity;
    private double shippingCost = 10.0;
    private boolean discountApplied = false;

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCount() {
        return totalQuantity;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public boolean isDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(boolean discountApplied) {
        this.discountApplied = discountApplied;
    }

    public String toString() {
        return "Order{" +
                "totalPrice=" + totalPrice +
                ", totalQuantity=" + totalQuantity +
                ", shippingCost=" + shippingCost +
                '}';
    }

    public void addItem(Item item) {
        items.add(item);
        totalPrice += item.getPrice() * item.getQuantity();
        totalQuantity += item.getQuantity();
        notifyObservers();
    }

    public void removeItem(Item item) {
        if (items.remove(item)) {
            totalPrice -= item.getPrice() * item.getQuantity();
            totalQuantity -= item.getQuantity();
            notifyObservers();
        }
    }
}
