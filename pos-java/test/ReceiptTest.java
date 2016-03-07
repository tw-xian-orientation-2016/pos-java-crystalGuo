import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReceiptTest {

    @Test
    public void when_get_receiptItems_then_return_right_finalPrice() {

        Item[] allItems = Fixture.loasAllItems();
        ReceiptItem[] receiptItems = {
                new ReceiptItem(new CartItem("ITEM000001", 5.00, allItems)),
                new ReceiptItem(new CartItem("ITEM000003", 2.00, allItems)),
                new ReceiptItem(new CartItem("ITEM000005", 3.00, allItems))
        };

        Receipt receipt = new Receipt(receiptItems);

        assertThat(receipt.getFinalPrice(), is(51.00));
    }
}