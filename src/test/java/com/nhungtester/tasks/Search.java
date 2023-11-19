package com.nhungtester.tasks;

import com.nhungtester.entity.Product;
import com.nhungtester.ui.AdminAllProductUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import static org.openqa.selenium.Keys.ENTER;

public class Search {
    public static Performable byTheProduct(Product product) {
        return Task.where("{0} search the product", actor -> actor.attemptsTo(
                Click.on(AdminAllProductUI.SEARCH_TEXTBOX),
                Enter.theValue(product.getProductName()).into(AdminAllProductUI.SEARCH_TEXTBOX),
                Hit.the(ENTER).into(AdminAllProductUI.SEARCH_TEXTBOX),
                Click.on(AdminAllProductUI.PRODUCT_NAME_SEARCH_RESULT.of(product.getProductName()))
        ));
    }
}
