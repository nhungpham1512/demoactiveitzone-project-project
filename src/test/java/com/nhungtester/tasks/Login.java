package com.nhungtester.tasks;

import com.nhungtester.environment.Url;
import com.nhungtester.ui.AdminLoginUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

public class Login {

    public static Performable byAdmin() {
        return Task.where("{0} login by admin", actor -> actor.attemptsTo(
                Open.url(Url.BASE_URL),
                Click.on(AdminLoginUI.BUTTON_COPY_DEFAUT_ADMIN),
                Click.on(AdminLoginUI.BUTTON_LOGIN)
        ));
    }
}
