package com.nhungtester.entity;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Product {
    private String productName;

    private String unitType;
    private int stockQuantity;
    private int minQuantity;
    private int shippingTime;
    private double discount;
    private double discountFlashsale;
    private double unitPrice;
    private int tax;
    private int vat;
    private String color1;
    private String color2;

    private String attribute;

    private String size1;
    private  String size2;
    public String getColor1() {
        return color1;
    }

    public String getSize1() {
        return size1;
    }

    public String getSize2() {
        return size2;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getColor2() {
        return color2;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    Random random = new Random();

    public int getTax() {
        return tax;
    }

    public int getVat() {
        return vat;
    }

    public int getShippingTime() {
        return shippingTime;
    }

    public String getProductName() {
        return productName;
    }

    public String getUnitType() {
        return unitType;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public double getDiscount() {
        return discount;
    }

    public double getDiscountFlashsale() {
        return discountFlashsale;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setDiscountFlashsale(double discountFlashsale) {
        this.discountFlashsale = discountFlashsale;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setShippingTime(int shippingTime) {
        this.shippingTime = shippingTime;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public Map<String,String> productColors = new HashMap<>();
    public void setProductColor(){
        productColors.put("AliceBlue","F0F8FF" );
        productColors.put("Chocolate","D2691E");
    };

    public Map<String,String> productAttributes = new HashMap<>();
    public void setProductAttribute(){
        productAttributes.put("Size","1" );
        productAttributes.put("Fabric","2");
        //productAttributes.put("Sleeve","4" );
        //productAttributes.put("Wheel","5");
        //productAttributes.put("Liter","6" );
    };

    public Product(int shippingTime, double discount, double discountFlashsale, double unitPrice, int tax, int vat, String color1, String color2, String attribute, String size1, String size2) {
        this.productName = "VietTienAttribute"+ random.nextInt();
        this.unitType = "Pc";
        this.stockQuantity = 20;
        this.minQuantity = 1;
        this.shippingTime = shippingTime;
        this.discount = discount;
        this.discountFlashsale = discountFlashsale;
        this.unitPrice = unitPrice;
        this.tax = tax;
        this.vat = vat;
        this.color1 = color1;
        this.color2 = color2;
        this.attribute = attribute;
        this.size1 = size1;
        this.size2 = size2;
    }

    public Product(int stockQuantity, int minQuantity, int shippingTime, double discount, double discountFlashsale, double unitPrice, int tax, int vat) {
        this.productName = "VietTien"+ random.nextInt();
        this.unitType = "Pc";
        this.stockQuantity = stockQuantity;
        this.minQuantity = minQuantity;
        this.shippingTime = shippingTime;
        this.discount = discount;
        this.discountFlashsale = discountFlashsale;
        this.unitPrice = unitPrice;
        this.tax = tax;
        this.vat = vat;
    }

    public double getUnitPriceAfterTaxVatDiscount() {
        double unitPriceAfterTaxVatDiscount =0;
        return  unitPriceAfterTaxVatDiscount= (getUnitPriceAfterTaxVat()-getUnitPriceAfterTaxVat()*getSelectedDiscount()/100);
    }
    public double getUnitPriceAfterTaxVat(){
        double UnitPriceAfterTaxVat =0;
        if (getTax()==0 && getVat()==0){
            UnitPriceAfterTaxVat = getUnitPrice();
        } else if (getTax()==0) {
            UnitPriceAfterTaxVat = getUnitPrice()*(100+getVat())/100;
        } else if (getVat()==0) {
            UnitPriceAfterTaxVat = getUnitPrice()*(100+getTax())/100;
        } else {
            UnitPriceAfterTaxVat = (getUnitPrice()*(100+getTax())/100)*(100+getVat())/100;
        }
        return  UnitPriceAfterTaxVat;
    }



   /* public double getPriceAfterDiscount() {
        double priceAfterDiscount = 0;
        DecimalFormat df = new DecimalFormat("#.###");
        if (getDiscountFlashsale()==0){
            priceAfterDiscount= (getUnitPrice()-getUnitPrice()*getDiscount()/100);
        }
        else {
            priceAfterDiscount= (getUnitPrice()-getUnitPrice()*getDiscountFlashsale()/100);
        }
        String ds = df.format(priceAfterDiscount);
        return  priceAfterDiscount = Double.valueOf(ds);
    }*/

    public double getSelectedDiscount() {
        double getSelectedDiscount = 0;
        if (getDiscountFlashsale()==0){
            getSelectedDiscount= getDiscount();
        }
        else {
            getSelectedDiscount= getDiscountFlashsale();
        }
        return getSelectedDiscount;
    }

    public double getTotalPrice() {
        double totalPrice=0;
        return totalPrice= (getUnitPrice()+getUnitPrice()*getTax()/100+getUnitPrice()*getVat()/100)*(100-getSelectedDiscount())/100;
    }

}
