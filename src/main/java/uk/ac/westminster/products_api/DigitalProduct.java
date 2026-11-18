package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable{

        private double discountedPrice;


    private String downloadUrl;
    private double fileSizeMB;

    // no- arg constructor- Jakson needs this to build
    //an object from an incoming JSON request body
    DigitalProduct (){}

    public DigitalProduct (Long id, String name, double price, String downloadUrl, double fileSizeMB) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }

    //summary for degital product
    @Override
    public String getSummary(){
        return "Digital Product- " + getName() +  "| download from: " + downloadUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }


    @Override
    public void applyDiscount(double rate) {

    }

    @Override
    public double getDiscountedPrice() {
        return 0;
    }
}
