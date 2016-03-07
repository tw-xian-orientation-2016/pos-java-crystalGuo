import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PosProcessTest {

    @Test
    public void when_get_tags_then_should_return_cartItems_array() {

        PosProcess posProcess = new PosProcess();
        Item[] allItems = Fixture.loasAllItems();
        String[] tags = Fixture.loadTags();
        CartItem[] cartItems = posProcess.getCartItems(tags, allItems);

        assertThat(cartItems.length, is(3));
    }

    @Test
    public  void when_get_cartItems_then_should_return_receiptItems_array() {

        PosProcess posProcess = new PosProcess();
        Item[] allItems = Fixture.loasAllItems();

        CartItem[] cartItems = {
                new CartItem("ITEM000001", 5.00, allItems),
                new CartItem("ITEM000003", 2.00, allItems),
                new CartItem("ITEM000005", 3.00, allItems)
        };

        assertThat(posProcess.getReceiptItems(cartItems).length, is(3));
    }
}