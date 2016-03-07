import java.text.DecimalFormat;

public class Receipt {

    private ReceiptItem[] receiptItems;
    private double finalPrice;
    private double finalSaved;

    public Receipt(ReceiptItem[] receiptItems) {
        this.receiptItems = receiptItems;
    }

    public ReceiptItem[] getReceiptItems() {
        return receiptItems;
    }

    

}
