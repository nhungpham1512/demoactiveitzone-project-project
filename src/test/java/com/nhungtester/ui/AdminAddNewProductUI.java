package com.nhungtester.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AdminAddNewProductUI {
    public static final Target PRODUCTS_HREF = Target.the("product href")
            .locatedBy("//span[@class='aiz-side-nav-text' and text()='Products']");
    public static final Target ADD_NEW_PRODUCT_HREF = Target.the("add new product href")
            .locatedBy("//span[@class='aiz-side-nav-text' and text()='Add New product']");
    public static final Target PRODUCT_NAME_TEXTBOX = Target.the("product name textbox")
            .locatedBy("//input[@class='form-control' and @placeholder='Product Name']");
    public static final Target UNIT_TYPE_TEXTBOX = Target.the("unit text box")
            .locatedBy("//input[@class='form-control' and @name='unit']");
    public static final Target MIN_QTY_TEXTBOX = Target.the("min quantity text box")
            .locatedBy("//input[@class='form-control' and @name='min_qty']");
    public static final Target TAGS_TEXTBOX = Target.the("tags text box")
            .locatedBy("//span[@class='tagify__input']");
    public static final Target UNIT_PRICE_TEXTBOX = Target.the("unit price text box")
            .locatedBy("//input[@class='form-control' and @name='unit_price']");
    public static final Target DISCOUNT_DATE_RANGE_SELECTOR = Target.the("discount date range selector")
            .locatedBy("//input[@class='form-control aiz-date-range' and @name='date_range']");
    public static final Target DISCOUNT_START_DATE = Target.the("discount start date")
            .locatedBy("//td[text()='5' and @data-title='r1c0']");
    public static final Target DISCOUNT_END_DATE = Target.the("discount end date")
            .locatedBy("//td[text()='30' and @data-title='r4c4']");
    public static final Target DATE_RANGE_SELECT_BUTTON = Target.the("date range select button")
            .locatedBy("//button[@class='applyBtn btn btn-sm btn-primary' and text()='Select']");
    public static final Target DISCOUNT_TEXTBOX = Target.the("discount text box")
            .locatedBy("//input[@class='form-control' and @name='discount']");
    public static final Target DISCOUNT_METHOD_SELECTOR = Target.the("discount method selector")
            .locatedBy("//select[@name='discount_type']/following-sibling::button[@class='btn dropdown-toggle btn-light' and @title='Flat']");
    public static final Target MEN_CLOTHING_FASHION_PARENT_LABEL = Target.the("men clothing fashion parent label")
            .locatedBy("//input[@data-id='Men Clothing & Fashion']/parent::label/preceding-sibling::i");
    public static final Target OUTWEAR_JACKETS_PARENT_LABEL = Target.the("outwear jackets parent label")
            .locatedBy("//input[@data-id='Outwear & jackets']/parent::label/preceding-sibling::i");
    public static final Target SUIT_BLAZER_PARENT_LABEL_RADIO = Target.the("suit blazer parent label radio")
            .locatedBy("//input[@data-id='Suit & Blazer']/parent::label/following-sibling::input");
    public static final Target SAVE_AND_PUBLISH_BUTTON = Target.the("save and publish button")
            .locatedBy("//button[@class='btn btn-success action-btn']");
    public static final Target SUIT_BLAZER_PARENT_LABEL_CHECKBOX = Target.the("suit blazer parent label checkbox")
            .locatedBy("//input[@data-id='Suit & Blazer']/parent::label//input[@class='hummingbird-end-node']");
    public static final Target FLASH_DEAL_CARD_HEADER = Target.the("flash deal card header")
            .locatedBy("//h5[text()='Flash Deal']");
    public static final Target ADD_FILE_BROWSE = Target.the("upload image")
            .located(By.name("files[]"));
    public static final Target BUTTON_ADD_FILES = Target.the("add file button")
            .locatedBy("//button[text()='Add Files']");
    public static final Target TEXT_PRODUCT = Target.the("text product")
            .locatedBy("//h5[text()='Product Images']");
    public static final Target GALLERY_IMAGES_BROWSE_LABEL = Target.the("image browse label")
            .locatedBy("//label[text()='Gallery Images ']/following-sibling::div//div[@data-type='image']//div[text()='Browse']");
    public static final Target BRAND_SELECTOR = Target.the("brand selector")
            .locatedBy("//select[@name='brand_id']");
    public static final Target UPLOAD_BUTTON = Target.the("upload button")
            .locatedBy("//a[text()='Upload New']");
    public static final Target FLASH_DEAL_BUTTON = Target.the("flash deal button")
            .locatedBy("//button[@data-id='flash_deal']");
    public static final Target FLASH_DEAL_SELECTOR = Target.the("flash deal selector")
            .locatedBy("//select[@id='flash_deal']");
    public static final Target FLASH_DISCOUNT_TEXTBOX = Target.the("flash discount textbox")
            .locatedBy("//input[@name='flash_discount']");
    public static final Target FLASH_DISCOUNT_TYPE_BUTTON = Target.the("flash discount type button")
            .locatedBy("//button[@data-id='flash_discount_type']");
    public static final Target FLASH_DISCOUNT_TYPE_SELECTOR = Target.the("flash discount type selector")
            .locatedBy("//select[@id='flash_discount_type']");
    public static final Target STOCK_QUANTITY = Target.the("current stock quantity")
            .locatedBy("//input[@name='current_stock']");
    public static final Target SHIPPING_DAYS_TEXTBOX = Target.the("shipping days text box")
            .locatedBy("//input[@name='est_shipping_days']");
    public static final Target TAX_TEXTBOX = Target.the("tax text box")
            .locatedBy("//label[contains(text(),'Tax')]//following-sibling::div[1]//input[@name='tax[]']");
    public static final Target VAT_TEXTBOX = Target.the("vat text box")
            .locatedBy("//label[contains(text(),'Vat')]//following-sibling::div[1]//input[@name='tax[]']");
    public static final Target TAX_TYPE = Target.the("tax type")
            .locatedBy("//label[contains(text(),'Tax')]//following-sibling::div[1]//select[@name='tax_type[]']");
    public static final Target VAT_TYPE = Target.the("vat type")
            .locatedBy("//label[contains(text(),'Vat')]//following-sibling::div[1]//select[@name='tax_type[]']");
    public static final Target VARIATION_TOGGLE = Target.the("variant toggle")
            .locatedBy("//h5[text()='Product Variation']//parent::div//following-sibling::div[@class='card-body']//input[@type='checkbox']");
    public static final Target ATTRIBUTE_LABEL_INPUT = Target.the("attribute")
            .locatedBy("//label[text()='{0}-{1}']//ancestor::td//following-sibling::td[@class='footable-last-visible']//input");
}
