package jenkins.local.model.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jenkins.local.model.base.BaseViewConfigPage;
import jenkins.local.model.base.BaseViewPage;

public class MyViewsPage extends BaseViewPage<MyViewsPage> {

    @FindBy(className = "addTab")
    private WebElement newViewButton;

    public MyViewsPage(WebDriver driver) {
        super(driver);
    }

    public NewViewPageFromMyViewsPage<?> clickNewViewButton() {
        newViewButton.click();
        return new NewViewPageFromMyViewsPage<>(getDriver(),
                new BaseViewConfigPage(getDriver()) {
                });
    }
}
