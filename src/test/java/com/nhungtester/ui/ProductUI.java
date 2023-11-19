package com.nhungtester.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductUI {
    public static final Target PRODUCT_NAME_TEXT = Target.the("product name text")
            .locatedBy("//h2[@class='mb-4 fs-16 fw-700 text-dark']");
    public static final Target UNIT_PRICE_TEXT = Target.the("price unit text")
            .locatedBy("//div[text()='Price' and @class='text-secondary fs-14 fw-400']/parent::div/following-sibling::div//del");
    public static final Target UNIT_TYPE_TEXT = Target.the("unit type text")
            .locatedBy("//div[text()='Price' and @class='text-secondary fs-14 fw-400']/parent::div/following-sibling::div//span[@class='opacity-70 ml-1']");
    public static final Target DISCOUNT_TEXT = Target.the("discount text")
            .locatedBy("//div[text()='Price' and @class='text-secondary fs-14 fw-400']/parent::div/following-sibling::div//span[@class='bg-primary ml-2 fs-11 fw-700 text-white w-35px text-center p-1']");
    public static final Target PRICE_AFTER_DISCOUNT_TEXT = Target.the("price after discount")
            .locatedBy("//div[text()='Price' and @class='text-secondary fs-14 fw-400']/parent::div/following-sibling::div//strong[@class='fs-16 fw-700 text-primary']");
    public static final Target MIN_QUANTITY_TEXT = Target.the("min quantity text")
            .locatedBy("//div[text()='Quantity']/ancestor::div[@class='row no-gutters mb-3']/div[@class='col-sm-10']//input[@name='quantity']");
    public static final Target SUBSCRIBE_CONTENT_POPUP_CLOSE_BUTTON = Target.the("subscribe content popup close button")
            .locatedBy("//div[@class='modal-content position-relative border-0 rounded-0']//button[@class='absolute-top-right bg-white shadow-lg btn btn-circle btn-icon mr-n3 mt-n3 set-session']");
    public static final Target TOTAL_PRICE = Target.the("total price")
            .locatedBy("//div[text()='Total Price' and @class='text-secondary fs-14 fw-400 mt-1']/parent::div/following-sibling::div//strong[@id='chosen_price']");
    public static final Target SHIPPING_TIME = Target.the("shipping time")
            .locatedBy("//small[text()='Estimate Shipping Time:']//following-sibling::span");
}
