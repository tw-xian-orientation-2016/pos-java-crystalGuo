public class CartItem {

    private Item item;
    private double count;

    public CartItem(String barcode, double count, Item[] allItems) {
        this.item = findItem(barcode, allItems);
        this.count = count;
    }

    private Item findItem(String barcode, Item[] allItems) {

        for (int i = 0; i < allItems.length; i++) {
            if (barcode.equals(allItems[i].getBarcode())) {
                return allItems[i];
            }
        }

        return null;
    }

    public Item getItem() {
        return item;
    }

    public double getCount() {
        return count;
    }
}
