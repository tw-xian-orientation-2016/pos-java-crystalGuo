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
}