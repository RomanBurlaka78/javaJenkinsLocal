package jenkins.local.model.jobs.details;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jenkins.local.model.HomePage;
import jenkins.local.model.base.BaseDetailsPage;
import jenkins.local.model.jobs.configs.OrganizationFolderConfigurationPage;

public class OrganizationFolderDetailsPage extends BaseDetailsPage<OrganizationFolderConfigurationPage, OrganizationFolderDetailsPage> {

    @FindBy(name = "Submit")
    private WebElement submitButton;

    @FindBy(linkText = "Delete Organization Folder")
    private WebElement buttonDelete;

    @FindBy(id = "view-message")
    private WebElement descriptionText;

    public OrganizationFolderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected OrganizationFolderConfigurationPage createConfigurationPage() {
        return new OrganizationFolderConfigurationPage(getDriver());
    }

    public HomePage clickDelete() {
        buttonDelete.click();
        submitButton.click();

        return new HomePage(getDriver());
    }

    public String getDescriptionTextOrganizationFolder() {
        return descriptionText.getText();
    }
}
