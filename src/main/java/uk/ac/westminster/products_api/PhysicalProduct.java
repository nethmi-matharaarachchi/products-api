package uk.ac.westminster.products_api;

    //A PhysicalProduct IS-A Product because it can be counted as a type of Product that is getting shipped
    //Shopping cart is not a Product because it HAS-A Product rather than being a Product


public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimensions;

    private double discountedPrice;

    PhysicalProduct() {}



    public PhysicalProduct (Long id, String name, double price, double weightKg, String dimensions){
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    //summary for PhysicalProduct
    @Override
    public String getSummary(){
        return "Physical Product: " + getName() +" | weight: "+ getWeightKg();
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        discountedPrice = getPrice() * (1 - capped);

    }

    @Override
    public double getDiscountedPrice() {

        return discountedPrice;
    }
}


