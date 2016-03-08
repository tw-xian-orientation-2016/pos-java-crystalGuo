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

    public String getReceipt() {

        String receipt = "***<没钱赚商店>收据***\n";

        for (ReceiptItem receiptItem: receiptItems) {
            receipt +=
                    "名称：" + receiptItem.getName() + "，" +
                    "数量：" + formatCount(receiptItem.getCount()) + receiptItem.getUnit() + "，" +
                    "单价：" + formatPrice(receiptItem.getPrice()) + "(元)，" +
                    "小计：" + formatPrice(receiptItem.getTotalPrice()) + "(元)\n";
        }

        receipt += "----------------------\n";
        receipt +=
                "总计：" + formatPrice(getFinalPrice()) + "(元)\n" +
                "节省：" + formatPrice(getFinalSaved()) + "(元)\n" +
                        "**********************";

        return receipt.toString();

    }

    private String formatPrice(double price) {

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        return decimalFormat.format(price);
    }

    private String formatCount(double count) {

        DecimalFormat decimalFormat = new DecimalFormat("0.##");

        return decimalFormat.format(count);
    }

}
