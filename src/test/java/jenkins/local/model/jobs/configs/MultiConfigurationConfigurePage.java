package jenkins.local.model.jobs.configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jenkins.local.model.base.BaseConfigurationPage;
import jenkins.local.model.jobs.details.MultiConfigurationDetailsPage;

public class MultiConfigurationConfigurePage extends BaseConfigurationPage<MultiConfigurationDetailsPage, MultiConfigurationConfigurePage> {
    @FindBy(name = "description")
    private WebElement inputDescription;

    public MultiConfigurationConfigurePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected MultiConfigurationDetailsPage createProjectPage() {
        return new MultiConfigurationDetailsPage(getDriver());
    }

    public MultiConfigurationConfigurePage inputDescription(String description) {
        inputDescription.sendKeys(description);

        return this;
    }
}
