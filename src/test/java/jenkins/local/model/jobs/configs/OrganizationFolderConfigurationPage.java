package jenkins.local.model.jobs.configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import jenkins.local.model.base.BaseConfigurationPage;
import jenkins.local.model.jobs.details.OrganizationFolderDetailsPage;

public class OrganizationFolderConfigurationPage extends BaseConfigurationPage<OrganizationFolderDetailsPage, OrganizationFolderConfigurationPage> {

    @FindBy(xpath = "//section[2]//label")
    private WebElement periodicallyCheckbox;

    public OrganizationFolderConfigurationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected OrganizationFolderDetailsPage createProjectPage() {
        return new OrganizationFolderDetailsPage(getDriver());
    }

    public OrganizationFolderConfigurationPage clickPeriodicallyCheckbox() {
        new Actions(getDriver())
                .moveToElement(periodicallyCheckbox)
                .click()
                .perform();

        return this;
    }
}
