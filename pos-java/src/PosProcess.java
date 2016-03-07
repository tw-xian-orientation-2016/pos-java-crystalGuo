import java.util.ArrayList;

public class PosProcess {

    public CartItem[] getCartItems(String[] tags, Item[] allItems) {

        ArrayList<CartItem> cartItems = new ArrayList<>();

        for (int i = 0; i < tags.length; i++) {
            String[] barcodeArr = tags[i].split("-");
            String barcode = barcodeArr[0];
            double count = barcodeArr.length > 1 ? Double.parseDouble(barcodeArr[1]) : 1;

            CartItem cartItem = findCartItem(barcode, cartItems);

            if (cartItem != null) {
                cartItem.setCount(cartItem.getCount() + count);
            } else {
                cartItems.add(new CartItem(barcode, count, allItems));
            }
        }

        return cartItems.toArray(new CartItem[cartItems.size()]);
    }

    private CartItem findCartItem(String barcode, ArrayList<CartItem> cartItems) {

        for (int i = 0; i < cartItems.size(); i++) {
            CartItem cartItem = cartItems.get(i);

            if (barcode.equals(cartItem.getItem().getBarcode())) {
                return cartItem;
            }
        }

        return null;
    }
}