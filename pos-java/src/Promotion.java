public class Promotion {

    private String type;
    private String[] barcodes;

    public Promotion(String type, String[] barcodes) {
        this.type = type;
        this.barcodes = barcodes;
    }

    public String getType() {
        return type;
    }

    public String[] getBarcodes() {
        return barcodes;
    }
}
