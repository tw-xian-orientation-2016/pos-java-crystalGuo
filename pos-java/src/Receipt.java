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

    public double getFinalPrice() {

        for (ReceiptItem receiptItem: receiptItems) {
            finalPrice += receiptItem.getTotalPrice();
        }

        return finalPrice;
    }

    public double getFinalSaved() {

        for (ReceiptItem receiptItem: receiptItems) {
            finalSaved += receiptItem.getSavedPrice();
        }

        return finalSaved;
    }

    

}
