public class ReceiptItem {

    private CartItem cartItem;
    private double totalPrice;
    private double savedPrice;

    public ReceiptItem(CartItem cartItem) {

        this.cartItem = cartItem;
        this.savedPrice = getSavedPrice(cartItem.getPromotionType(
                cartItem.getItem().getBarcode(),Fixture.loadAllPromotions() ));
        this.totalPrice = cartItem.getCount() * cartItem.getItem().getPrice() - savedPrice;
    }

    private double getSavedPrice(String promotionType) {

        if (promotionType.equals("BUY_TWO_GET_ONE_FREE")) {
            return (int)(cartItem.getCount() / 3) * cartItem.getItem().getPrice();
        }

        return 0.00;
    }

    public String getName() {
        return cartItem.getItem().getName();
    }

    public double getCount() {
        return cartItem.getCount();
    }

    public String getUnit() {
        return cartItem.getItem().getUnit();
    }

    public double getPrice() {
        return cartItem.getItem().getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getSavedPrice() {
        return savedPrice;
    }
}
