package jenkins.local.model.jobs.details;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jenkins.local.model.base.BaseDetailsPage;
import jenkins.local.model.jobs.configs.MultiConfigurationConfigurePage;

public class MultiConfigurationDetailsPage extends BaseDetailsPage<MultiConfigurationConfigurePage, MultiConfigurationDetailsPage> {

    @FindBy(css = "a[data-message]")
    private WebElement taskLinkDeleteMultiConfigurationProject;

    public MultiConfigurationDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected MultiConfigurationConfigurePage createConfigurationPage() {
        return new MultiConfigurationConfigurePage(getDriver());
    }

    public MultiConfigurationDetailsPage taskLinkDeleteMultiConfigurationProject() {
        taskLinkDeleteMultiConfigurationProject.click();

        return this;
    }
}
