import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    public void when_get_cartItems_then_should_return_receiptItems_array() {

        PosProcess posProcess = new PosProcess();
        Item[] allItems = Fixture.loasAllItems();

        CartItem[] cartItems = {
                new CartItem("ITEM000001", 5.00, allItems),
                new CartItem("ITEM000003", 2.00, allItems),
                new CartItem("ITEM000005", 3.00, allItems)
        };

        assertThat(posProcess.getReceiptItems(cartItems).length, is(3));
    }

    @Test
    public void when_print_receipt_then_print_it() {

        PosProcess posProcess = mock(PosProcess.class);

        String receipt = "***<没钱赚商店>收据***\n" +
                "名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)\n" +
                "名称：荔枝，数量：2斤，单价：15.00(元)，小计：30.00(元)\n" +
                "名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)\n" +
                "----------------------\n" +
                "总计：51.00(元)\n" +
                "节省：7.50(元)\n" +
                "**********************";

        posProcess.printReceipt(receipt);

        verify(posProcess).printReceipt(receipt);
    }
}