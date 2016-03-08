import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ReceiptItemTest {

    @Test
    public void test_when_calculate_total_price_then_return_right_answer() throws Exception {

        CartItem cartItem = new CartItem("ITEM000001", 5, Fixture.loasAllItems());
        ReceiptItem receiptItem = new ReceiptItem(cartItem);

        assertThat(12.00 == receiptItem.getTotalPrice(), is(true));
    }

    
}