package com.nhungtester.features.create;

import com.nhungtester.entity.Unit;
import com.nhungtester.entity.Product;
import com.nhungtester.tasks.CreateItem;
import com.nhungtester.tasks.Login;
import com.nhungtester.tasks.Search;
import com.nhungtester.ui.ProductUI;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Absence;
import net.serenitybdd.screenplay.questions.Displayed;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static java.lang.Math.round;

@RunWith(SerenityRunner.class)
public class WhenCreateItem {

    public static final Target AVAILABLE_QUANTITY_TEXT = Target.the("available quantity")
            .locatedBy("//span[@id='available-quantity']");
    Actor nhungtester = Actor.named("Nhungtester");
    //BigDecimal bigdecimal = new BigDecimal(),

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;


    @Before
    public void nhungtesterCanBrowseTheWeb() {
        nhungtester.can(BrowseTheWeb.with(herBrowser));
    }

    @WithTag("testcase01")
    @Test
    public void should_succeed_with_out_of_stock_when_create_a_new_product_with_stockQuantity_equal_0() {
        Product shirt = new Product(0,10,1, 4.5,10,100,10,10);
        nhungtester.wasAbleTo(
                Login.byAdmin(),
                CreateItem.aProduct(shirt),
                Search.byTheProduct(shirt),
                Switch.toTheOtherWindow(),
                Click.on(ProductUI.SUBSCRIBE_CONTENT_POPUP_CLOSE_BUTTON)
        );
        boolean addToCartButtonDisplay = nhungtester.asksFor(Displayed.of("//button[@onclick='addToCart()']"));
        boolean buyNowButtonDisplay = nhungtester.asksFor(Displayed.of("//button[@onclick='buyNow()']"));
        boolean outOfStockNotPresent = nhungtester.asksFor(Absence.of("//button[@class='btn btn-secondary out-of-stock fw-600']"));
        boolean shippingTimeNotPresent = nhungtester.asksFor(Absence.of("//small[text()='Estimate Shipping Time:']"));
        nhungtester.attemptsTo(
                //Ensure.that(BrowseTheWeb.as(nhungtester).getTitle()).contains(shirt.getProductName()),
                Ensure.that(ProductUI.PRODUCT_NAME_TEXT).text().isEqualTo(shirt.getProductName()),
                Ensure.that(ProductUI.UNIT_PRICE_TEXT).text().isEqualTo(Unit.formatCurrency(shirt.getUnitPriceAfterTaxVat())),
                Ensure.that(ProductUI.UNIT_TYPE_TEXT).text().contains(shirt.getUnitType()),
                Ensure.that(ProductUI.DISCOUNT_TEXT).text().isEqualTo(String.valueOf(round(shirt.getSelectedDiscount())*-1)+'%'),
                Ensure.that(ProductUI.PRICE_AFTER_DISCOUNT_TEXT).text().isEqualTo(Unit.formatCurrency(shirt.getUnitPriceAfterTaxVatDiscount())),
                Ensure.that(ProductUI.MIN_QUANTITY_TEXT).attribute("value").isEqualTo(String.valueOf(shirt.getMinQuantity())),
                Ensure.that(ProductUI.TOTAL_PRICE).text().isEqualTo(Unit.formatCurrency(shirt.getTotalPrice())),
                Ensure.that(addToCartButtonDisplay).isTrue(),
                Ensure.that(buyNowButtonDisplay).isTrue(),
                Ensure.that(outOfStockNotPresent).isTrue(),
                Check.whether(shirt.getShippingTime() >0)
                        .andIfSo(Ensure.that(shippingTimeNotPresent).isFalse(),
                                Ensure.that(ProductUI.SHIPPING_TIME).text().isEqualTo(String.valueOf(shirt.getShippingTime())+" Days")
                        )
                        .otherwise(Ensure.that(shippingTimeNotPresent).isTrue())
        );
    }
    @WithTag("testcase02")
    @Test
    public void should_succeed_with_out_of_stock_when_create_a_new_product_with_stockQuantity_is_smaller_than_minQuantity() {
        Product shirt = new Product(2,4,10, 4.5,10,100,10,10);
        nhungtester.wasAbleTo(
                Login.byAdmin(),
                CreateItem.aProduct(shirt),
                Search.byTheProduct(shirt),
                Switch.toTheOtherWindow(),
                Click.on(ProductUI.SUBSCRIBE_CONTENT_POPUP_CLOSE_BUTTON)
        );
        boolean addToCartButtonDisplay = nhungtester.asksFor(Displayed.of("//button[@onclick='addToCart()']"));
        boolean buyNowButtonDisplay = nhungtester.asksFor(Displayed.of("//button[@onclick='buyNow()']"));
        boolean outOfStockNotPresent = nhungtester.asksFor(Absence.of("//button[@class='btn btn-secondary out-of-stock fw-600']"));
        boolean shippingTimeNotPresent = nhungtester.asksFor(Absence.of("//small[text()='Estimate Shipping Time:']"));
        nhungtester.attemptsTo(
                //Ensure.that(BrowseTheWeb.as(nhungtester).getTitle()).contains(shirt.getProductName()),
                Ensure.that(ProductUI.PRODUCT_NAME_TEXT).text().isEqualTo(shirt.getProductName()),
                Ensure.that(ProductUI.UNIT_PRICE_TEXT).text().isEqualTo(Unit.formatCurrency(shirt.getUnitPriceAfterTaxVat())),
                Ensure.that(ProductUI.UNIT_TYPE_TEXT).text().contains(shirt.getUnitType()),
                Ensure.that(ProductUI.DISCOUNT_TEXT).text().isEqualTo(String.valueOf(round(shirt.getSelectedDiscount())*-1)+'%'),
                Ensure.that(ProductUI.PRICE_AFTER_DISCOUNT_TEXT).text().isEqualTo(Unit.formatCurrency(shirt.getUnitPriceAfterTaxVatDiscount())),
                Ensure.that(ProductUI.MIN_QUANTITY_TEXT).attribute("value").isEqualTo(String.valueOf(shirt.getMinQuantity())),
                Ensure.that(ProductUI.TOTAL_PRICE).text().isEqualTo(Unit.formatCurrency(shirt.getTotalPrice())),
                Ensure.that(addToCartButtonDisplay).isTrue(),
                Ensure.that(buyNowButtonDisplay).isTrue(),
                Ensure.that(outOfStockNotPresent).isTrue(),
                Check.whether(shirt.getShippingTime() >0)
                        .andIfSo(Ensure.that(shippingTimeNotPresent).isFalse(),
                                Ensure.that(ProductUI.SHIPPING_TIME).text().isEqualTo(String.valueOf(shirt.getShippingTime())+" Days")
                        )
                        .otherwise(Ensure.that(shippingTimeNotPresent).isTrue())
        );
    }
    @WithTag("testcase03")
    @Test
    public void should_succeed_with_being_sold_when_create_a_new_product_with_stockQuantity_is_greater_than_minQuantity() {
        Product shirt = new Product(10,1,2, 4.5,10,100,10,10);
        nhungtester.wasAbleTo(
                Login.byAdmin(),
                CreateItem.aProduct(shirt),
                Search.byTheProduct(shirt),
                Switch.toTheOtherWindow(),
                Click.on(ProductUI.SUBSCRIBE_CONTENT_POPUP_CLOSE_BUTTON)
        );
        boolean addToCartButtonDisplay = nhungtester.asksFor(Displayed.of("//button[@onclick='addToCart()']"));
        boolean buyNowButtonDisplay = nhungtester.asksFor(Displayed.of("//button[@onclick='buyNow()']"));
        boolean outOfStockNotPresent = nhungtester.asksFor(Absence.of("//button[@class='btn btn-secondary out-of-stock fw-600']"));
        boolean shippingTimeNotPresent = nhungtester.asksFor(Absence.of("//small[text()='Estimate Shipping Time:']"));
        nhungtester.attemptsTo(
                //Ensure.that(BrowseTheWeb.as(nhungtester).getTitle()).contains(shirt.getProductName()),
                Ensure.that(ProductUI.PRODUCT_NAME_TEXT).text().isEqualTo(shirt.getProductName()),
                Ensure.that(ProductUI.UNIT_PRICE_TEXT).text().isEqualTo(Unit.formatCurrency(shirt.getUnitPriceAfterTaxVat())),
                Ensure.that(ProductUI.UNIT_TYPE_TEXT).text().contains(shirt.getUnitType()),
                Ensure.that(ProductUI.DISCOUNT_TEXT).text().isEqualTo(String.valueOf(round(shirt.getSelectedDiscount())*-1)+'%'),
                Ensure.that(ProductUI.PRICE_AFTER_DISCOUNT_TEXT).text().isEqualTo(Unit.formatCurrency(shirt.getUnitPriceAfterTaxVatDiscount())),
                Ensure.that(ProductUI.MIN_QUANTITY_TEXT).attribute("value").isEqualTo(String.valueOf(shirt.getMinQuantity())),
                Ensure.that(ProductUI.TOTAL_PRICE).text().isEqualTo(Unit.formatCurrency(shirt.getTotalPrice())),
                Ensure.that(addToCartButtonDisplay).isTrue(),
                Ensure.that(buyNowButtonDisplay).isTrue(),
                Ensure.that(outOfStockNotPresent).isTrue(),
                Check.whether(shirt.getShippingTime() >0)
                        .andIfSo(Ensure.that(shippingTimeNotPresent).isFalse(),
                                Ensure.that(ProductUI.SHIPPING_TIME).text().isEqualTo(String.valueOf(shirt.getShippingTime())+" Days")
                        )
                        .otherwise(Ensure.that(shippingTimeNotPresent).isTrue())
        );
    }


    @WithTag("testcase04")
    @Test
    public void should_succeed_with_product_variation_when_create_a_new_product_with_color_and_size_variation() {
        Product shirt = new Product(2,4.5,10,100,10,10,"AliceBlue","Chocolate","Size", "L","M");
        nhungtester.wasAbleTo(
                Login.byAdmin(),
                CreateItem.aProductWithVariation(shirt),
                Search.byTheProduct(shirt),
                Switch.toTheOtherWindow(),
                Click.on(ProductUI.SUBSCRIBE_CONTENT_POPUP_CLOSE_BUTTON)
        );
        boolean addToCartButtonDisplay = nhungtester.asksFor(Displayed.of("//button[@onclick='addToCart()']"));
        boolean buyNowButtonDisplay = nhungtester.asksFor(Displayed.of("//button[@onclick='buyNow()']"));
        boolean outOfStockNotPresent = nhungtester.asksFor(Absence.of("//button[@class='btn btn-secondary out-of-stock fw-600']"));
        boolean shippingTimeNotPresent = nhungtester.asksFor(Absence.of("//small[text()='Estimate Shipping Time:']"));
        nhungtester.attemptsTo(
                //Ensure.that(BrowseTheWeb.as(nhungtester).getTitle()).contains(shirt.getProductName()),
                Ensure.that(ProductUI.PRODUCT_NAME_TEXT).text().isEqualTo(shirt.getProductName()),
                Ensure.that(ProductUI.UNIT_PRICE_TEXT).text().isEqualTo(Unit.formatCurrency(shirt.getUnitPriceAfterTaxVat())),
                Ensure.that(ProductUI.UNIT_TYPE_TEXT).text().contains(shirt.getUnitType()),
                Ensure.that(ProductUI.DISCOUNT_TEXT).text().isEqualTo(String.valueOf(round(shirt.getSelectedDiscount())*-1)+'%'),
                Ensure.that(ProductUI.PRICE_AFTER_DISCOUNT_TEXT).text().isEqualTo(Unit.formatCurrency(shirt.getUnitPriceAfterTaxVatDiscount())),
                Ensure.that(ProductUI.MIN_QUANTITY_TEXT).attribute("value").isEqualTo(String.valueOf(shirt.getMinQuantity())),
                Ensure.that(ProductUI.TOTAL_PRICE).text().isEqualTo(Unit.formatCurrency(shirt.getTotalPrice())),
                Ensure.that(addToCartButtonDisplay).isTrue(),
                Ensure.that(buyNowButtonDisplay).isTrue(),
                Ensure.that(outOfStockNotPresent).isTrue(),
                Check.whether(shirt.getShippingTime() >0)
                        .andIfSo(Ensure.that(shippingTimeNotPresent).isFalse(),
                                Ensure.that(ProductUI.SHIPPING_TIME).text().isEqualTo(String.valueOf(shirt.getShippingTime())+" Days")
                        )
                        .otherwise(Ensure.that(shippingTimeNotPresent).isTrue())
        );
    }
}