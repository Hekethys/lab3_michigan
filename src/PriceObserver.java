public class PriceObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getTotalPrice() > 200 && !order.isDiscountApplied()) {
            order.setTotalPrice(order.getTotalPrice() - 20);
            order.setDiscountApplied(true);
        } else if (order.getTotalPrice() <= 200 && order.isDiscountApplied()) {
            order.setTotalPrice(order.getTotalPrice() + 20);
            order.setDiscountApplied(false);
        }
    }
}
