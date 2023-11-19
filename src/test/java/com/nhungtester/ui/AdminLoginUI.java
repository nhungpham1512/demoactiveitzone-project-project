package com.nhungtester.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AdminLoginUI {
    public static final Target BUTTON_LOGIN = Target.the("login button")
            .locatedBy("//button[contains(text(),'Login')]");
    public static final Target BUTTON_COPY_DEFAUT_ADMIN = Target.the("copy admin account and pwd")
            .locatedBy("//button[text()='Copy']");
    public static final Target UPLOAD_IMAGE_BUTTON_BROWSE = Target.the("upload image button")
            .locatedBy("//button[text()='Browse']");
}
