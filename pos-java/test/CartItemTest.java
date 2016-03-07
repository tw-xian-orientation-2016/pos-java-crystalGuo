import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CartItemTest {

    @Test
    public void when_get_barcode_then_return_item() throws Exception {

        CartItem cartItem = new CartItem("ITEM000001", 5, Fixture.loasAllItems());
        Item item = new Item("ITEM000001", "雪碧", "瓶", 3.00);

        assertEquals(item.getBarcode(), cartItem.getItem().getBarcode());
        assertEquals(item.getName(), cartItem.getItem().getName());
        assertEquals(item.getUnit(), cartItem.getItem().getUnit());
        assertThat(item.getPrice() == cartItem.getItem().getPrice(), is(true));
    }
}