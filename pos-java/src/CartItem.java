public class CartItem {

    private Item item;
    private double count;
    private String promotionType;

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

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public String getPromotionType(String barcode, Promotion[] promotions) {

        for (int i = 0; i < promotions.length; i++) {

            String[] barcodes = promotions[i].getBarcodes();

            for (int index = 0; index < barcodes.length; index++) {
                if (barcode.equals(barcodes[index])) {
                    return promotions[i].getType();
                }
            }
        }
        return "";
    }
}
