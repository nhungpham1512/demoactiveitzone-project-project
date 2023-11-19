package com.nhungtester.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AdminAllProductUI {
    public static final Target SEARCH_TEXTBOX = Target.the("search text box")
            .locatedBy("//input[@id='search']");
    public static final Target PRODUCT_NAME_SEARCH_RESULT = Target.the("{0} product name")
            .locatedBy("//span[text()='{0}']/ancestor::tr//i[@class='las la-eye']");
    public static final Target THE_PRODUCT_VIEW = Target.the("the {0} product view")
            .locatedBy("//span[text()='{0}']/ancestor::td/following-sibling::td[@class='text-right footable-last-visible']/a[@class='btn btn-soft-success btn-icon btn-circle btn-sm']");
}
