package com.nhungtester.tasks;

import com.nhungtester.entity.Product;
import com.nhungtester.ui.AdminAddNewProductUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.nhungtester.ui.AdminAddNewProductUI.STOCK_QUANTITY;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;


public class CreateItem {


    public static final String SOURCEPATH_SHIRT_BLUE_JPG = "D:\\Nhung-tester\\Automation_ALinh\\nhungproject-workingspace\\image\\shirtBlue.jpg";

    static Path filePath = Paths.get(SOURCEPATH_SHIRT_BLUE_JPG);

    public static Performable aProduct(Product product) {
        return
                Task.where("{0} create a product", actor -> {
                        actor.attemptsTo(
                                Click.on(AdminAddNewProductUI.PRODUCTS_HREF),
                                Click.on(AdminAddNewProductUI.ADD_NEW_PRODUCT_HREF),
                                Enter.theValue(product.getProductName()).into(AdminAddNewProductUI.PRODUCT_NAME_TEXTBOX),
                                Select.option("Addidas").from(AdminAddNewProductUI.BRAND_SELECTOR),
                                Enter.theValue(product.getUnitType()).into(AdminAddNewProductUI.UNIT_TYPE_TEXTBOX),
                                Clear.field(AdminAddNewProductUI.MIN_QTY_TEXTBOX),
                                Enter.theValue(String.valueOf(product.getMinQuantity())).into(AdminAddNewProductUI.MIN_QTY_TEXTBOX),
                                Enter.theValue(product.getProductName()).into(AdminAddNewProductUI.TAGS_TEXTBOX),
                                Enter.theValue(String.valueOf(product.getUnitPrice())).into(AdminAddNewProductUI.UNIT_PRICE_TEXTBOX),
                                Click.on(AdminAddNewProductUI.DISCOUNT_DATE_RANGE_SELECTOR),
                                Click.on(AdminAddNewProductUI.DISCOUNT_START_DATE),
                                Click.on(AdminAddNewProductUI.DISCOUNT_END_DATE),
                                Click.on(AdminAddNewProductUI.DATE_RANGE_SELECT_BUTTON),
                                Enter.theValue(String.valueOf(product.getDiscount())).into(AdminAddNewProductUI.DISCOUNT_TEXTBOX),
                                Click.on(AdminAddNewProductUI.DISCOUNT_METHOD_SELECTOR),
                                Hit.the(Keys.ARROW_DOWN).into(AdminAddNewProductUI.DISCOUNT_METHOD_SELECTOR),
                                Hit.the(Keys.ENTER).into(AdminAddNewProductUI.DISCOUNT_METHOD_SELECTOR),
                                Enter.theValue(String.valueOf(product.getStockQuantity())).into(STOCK_QUANTITY),
                                Scroll.to(AdminAddNewProductUI.TEXT_PRODUCT),
                                Click.on(AdminAddNewProductUI.GALLERY_IMAGES_BROWSE_LABEL),
                                Click.on(AdminAddNewProductUI.UPLOAD_BUTTON),
                                //Upload file C1
                                SendKeys.of(SOURCEPATH_SHIRT_BLUE_JPG)
                                        .into(AdminAddNewProductUI.ADD_FILE_BROWSE),
                                //Upload file C2
                                // Upload.theFile(filePath).to(ADD_FILE_BROWSE),
                                Click.on(AdminAddNewProductUI.BUTTON_ADD_FILES),
                                Click.on(AdminAddNewProductUI.GALLERY_IMAGES_BROWSE_LABEL),
                                Click.on("//span[text()='shirtBlue']"),
                                Click.on(AdminAddNewProductUI.BUTTON_ADD_FILES),
                                Scroll.to(AdminAddNewProductUI.MEN_CLOTHING_FASHION_PARENT_LABEL),
                                JavaScriptClick.on(AdminAddNewProductUI.MEN_CLOTHING_FASHION_PARENT_LABEL),
                                JavaScriptClick.on(AdminAddNewProductUI.OUTWEAR_JACKETS_PARENT_LABEL),
                                JavaScriptClick.on(AdminAddNewProductUI.SUIT_BLAZER_PARENT_LABEL_RADIO),
                                JavaScriptClick.on(AdminAddNewProductUI.SUIT_BLAZER_PARENT_LABEL_CHECKBOX),
                                Scroll.to(AdminAddNewProductUI.FLASH_DEAL_CARD_HEADER),
                                Click.on(AdminAddNewProductUI.FLASH_DEAL_BUTTON),
                                Select.option("Falsh sale").from(AdminAddNewProductUI.FLASH_DEAL_SELECTOR),
                                Enter.theValue(String.valueOf(product.getDiscountFlashsale())).into(AdminAddNewProductUI.FLASH_DISCOUNT_TEXTBOX),
                                Click.on(AdminAddNewProductUI.FLASH_DISCOUNT_TYPE_BUTTON),
                                Select.option("Percent").from(AdminAddNewProductUI.FLASH_DISCOUNT_TYPE_SELECTOR),
                                //Shipping time
                                Enter.theValue(String.valueOf(product.getShippingTime())).into(AdminAddNewProductUI.SHIPPING_DAYS_TEXTBOX),
                                //Tax and Vat
                                Enter.theValue(String.valueOf(product.getTax())).into(AdminAddNewProductUI.TAX_TEXTBOX),
                                Select.option("Percent").from(AdminAddNewProductUI.TAX_TYPE),
                                Enter.theValue(String.valueOf(product.getVat())).into(AdminAddNewProductUI.VAT_TEXTBOX),
                                Select.option("Percent").from(AdminAddNewProductUI.VAT_TYPE),
                                Click.on(AdminAddNewProductUI.SAVE_AND_PUBLISH_BUTTON)
                        );
                });
    }

    public static Performable aProductWithVariation(Product product) {
        return
                Task.where("{0} create a product with variation", actor -> {
                    actor.attemptsTo(
                            Click.on(AdminAddNewProductUI.PRODUCTS_HREF),
                            Click.on(AdminAddNewProductUI.ADD_NEW_PRODUCT_HREF),
                            Enter.theValue(product.getProductName()).into(AdminAddNewProductUI.PRODUCT_NAME_TEXTBOX),
                            Enter.theValue(product.getUnitType()).into(AdminAddNewProductUI.UNIT_TYPE_TEXTBOX),
                            Clear.field(AdminAddNewProductUI.MIN_QTY_TEXTBOX),
                            Enter.theValue(String.valueOf(product.getMinQuantity())).into(AdminAddNewProductUI.MIN_QTY_TEXTBOX),
                            Enter.theValue(product.getProductName()).into(AdminAddNewProductUI.TAGS_TEXTBOX),
                            Enter.theValue(String.valueOf(product.getUnitPrice())).into(AdminAddNewProductUI.UNIT_PRICE_TEXTBOX),
                            Click.on(AdminAddNewProductUI.DISCOUNT_DATE_RANGE_SELECTOR),
                            Click.on(AdminAddNewProductUI.DISCOUNT_START_DATE),
                            Click.on(AdminAddNewProductUI.DISCOUNT_END_DATE),
                            Click.on(AdminAddNewProductUI.DATE_RANGE_SELECT_BUTTON),
                            Enter.theValue(String.valueOf(product.getDiscount())).into(AdminAddNewProductUI.DISCOUNT_TEXTBOX),
                            Click.on(AdminAddNewProductUI.DISCOUNT_METHOD_SELECTOR),
                            Hit.the(Keys.ARROW_DOWN).into(AdminAddNewProductUI.DISCOUNT_METHOD_SELECTOR),
                            Hit.the(Keys.ENTER).into(AdminAddNewProductUI.DISCOUNT_METHOD_SELECTOR),
                            Enter.theValue(String.valueOf(product.getStockQuantity())).into(STOCK_QUANTITY),
                            Scroll.to(AdminAddNewProductUI.MEN_CLOTHING_FASHION_PARENT_LABEL),
                            JavaScriptClick.on(AdminAddNewProductUI.MEN_CLOTHING_FASHION_PARENT_LABEL),
                            JavaScriptClick.on(AdminAddNewProductUI.OUTWEAR_JACKETS_PARENT_LABEL),
                            JavaScriptClick.on(AdminAddNewProductUI.SUIT_BLAZER_PARENT_LABEL_RADIO),
                            JavaScriptClick.on(AdminAddNewProductUI.SUIT_BLAZER_PARENT_LABEL_CHECKBOX),
                            Scroll.to(AdminAddNewProductUI.FLASH_DEAL_CARD_HEADER),
                            Click.on(AdminAddNewProductUI.FLASH_DEAL_BUTTON),
                            Select.option("Falsh sale").from(AdminAddNewProductUI.FLASH_DEAL_SELECTOR),
                            Enter.theValue(String.valueOf(product.getDiscountFlashsale())).into(AdminAddNewProductUI.FLASH_DISCOUNT_TEXTBOX),
                            Click.on(AdminAddNewProductUI.FLASH_DISCOUNT_TYPE_BUTTON),
                            Select.option("Percent").from(AdminAddNewProductUI.FLASH_DISCOUNT_TYPE_SELECTOR),
                            //Shipping time
                            Enter.theValue(String.valueOf(product.getShippingTime())).into(AdminAddNewProductUI.SHIPPING_DAYS_TEXTBOX),
                            //Tax and Vat
                            Enter.theValue(String.valueOf(product.getTax())).into(AdminAddNewProductUI.TAX_TEXTBOX),
                            Select.option("Percent").from(AdminAddNewProductUI.TAX_TYPE),
                            Enter.theValue(String.valueOf(product.getVat())).into(AdminAddNewProductUI.VAT_TEXTBOX),
                            Select.option("Percent").from(AdminAddNewProductUI.VAT_TYPE),
                            Scroll.to("//h5[text()='Product Variation']"),
                            //Click.on("//h5[text()='Product Variation']//parent::div//following-sibling::div[@class='card-body']//input[@type='checkbox']"),
                            JavaScriptClick.on(AdminAddNewProductUI.VARIATION_TOGGLE),
                            WaitUntil.the(AdminAddNewProductUI.VARIATION_TOGGLE,isEnabled()).forNoMoreThan(5).seconds(),
                            //SelectFromOptions.byVisibleText("AliceBlue").from("//select[@id='colors']"),
                            //Select.option("AliceBlue").from("//select[@id='colors']"),
                            Select.value(product.productColors.get(product.getColor1())).from("//select[@id='colors']"),
                            Select.value(product.productColors.get(product.getColor2())).from("//select[@id='colors']"),
                            Select.value(product.productAttributes.get(product.getAttribute())).from("//select[@id='choice_attributes']"),
                            Select.value(product.getSize1()).from("//select[@name='choice_options_1[]']"),
                            Select.value(product.getSize2()).from("//select[@name='choice_options_1[]']"),
                            Enter.theValue(String.valueOf(90)).into(AdminAddNewProductUI.ATTRIBUTE_LABEL_INPUT.of(product.getColor1(),product.getSize1())),
                            Enter.theValue(String.valueOf(100)).into(AdminAddNewProductUI.ATTRIBUTE_LABEL_INPUT.of(product.getColor1(),product.getSize2())),
                            Enter.theValue(String.valueOf(110)).into(AdminAddNewProductUI.ATTRIBUTE_LABEL_INPUT.of(product.getColor2(),product.getSize1())),
                            Enter.theValue(String.valueOf(120)).into(AdminAddNewProductUI.ATTRIBUTE_LABEL_INPUT.of(product.getColor2(),product.getSize2())),
                            Click.on(AdminAddNewProductUI.SAVE_AND_PUBLISH_BUTTON)
                    );
                });
    }
}
